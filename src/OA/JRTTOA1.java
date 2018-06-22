package OA;

/**
 * Created by mingyama on 3/24/18.
 */
import java.util.*;
public class JRTTOA1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        HashSet<Integer> list = new HashSet<>();

        for(int i = 0; i < n; i++){
            int cur = in.nextInt();
            if (!list.contains(Math.abs(cur-k)) && !list.contains(Math.abs(k+cur))) {
                list.add(cur);
            }
        }

        System.out.println(list.size());
    }

}
