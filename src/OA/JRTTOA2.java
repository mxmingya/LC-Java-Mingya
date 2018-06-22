package OA;

/**
 * Created by mingyama on 3/24/18.
 */

import java.util.*;
public class JRTTOA2 {

    public static void main(String[] agrs) {
        int n = new Scanner(System.in).nextInt();
        if (n % 2 == 1) {
            System.out.println(n - 1);
            return;
        }
        int modTimes = 0;
        int cur = n;
        while (cur % 2 == 0 && cur != 0) {
            cur %= 2;
            modTimes++;
        }
        if (cur == 0) {
            System.out.println(modTimes + 1);
            return;
        }
        System.out.println(modTimes + cur - 1);
    }
}
