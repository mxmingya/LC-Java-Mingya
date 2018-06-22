package FB;
import java.util.*;
/**
 * Created by mingyama on 11/1/17.
 */
public class FindDuplicateUsers {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<String, Integer> h = new HashMap();
        String[][] contacts = {
                { "John", "john@gmail.MultiplyString", "john@fb.MultiplyString"}, // 0
                { "Dan", "dan@gmail.MultiplyString", "+1234567"}, // 1
                {"john123", "+5412312", "john123@skype.MultiplyString"}, // 2
                { "john1985", "+5412312", "john@fb.MultiplyString"}  }; // 3

        int code = 0;
        for(int i = 0; i < contacts.length; i++) {
            int c = -1;
            Set<Integer> groupings = new HashSet<>();
            for(int j = 0; j < contacts[i].length; j++) {
                String s = contacts[i][j];
                if(h.containsKey(s)) {
                    System.out.println("been here: " + s);
                    int value=h.get(s);
                    groupings.add(value);
                    c = Math.min(c,value);
                }
            }
            if(c == -1) {
                c = code++;
            }
            else {
                groupings.remove(c);
                for(Integer k : groupings ) {
                    for(int m=0;m<contacts[0].length;m++)
                    {
                        h.put(contacts[k][m],c);
                    }
                }

            }
            for(int j = 0; j < contacts[i].length; j++) {
                String s = contacts[i][j];
                h.put(s,  c);
            }
        }

        for(int i = 0; i < contacts.length; i++) {
            System.out.println(h.get(contacts[i][0]));
        }
    }
}
