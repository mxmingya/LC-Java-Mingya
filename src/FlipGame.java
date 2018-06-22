/**
 * Created by mingyama on 10/8/17.
 */
import java.util.*;
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        if (s == null || s.length() == 0) return result;
        for (int i  = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) =='+') {
                StringBuilder temp = new StringBuilder(s);
                temp.setCharAt(i, '-');
                temp.setCharAt(i+1, '-');
                result.add(temp.toString());
            }
        }
        return result;
    }
}
