package OA;

import java.util.Scanner;

/**
 * Created by mingyama on 3/24/18.
 */
import java.util.*;

public class JRTTOA4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aLength = sc.nextInt();
        int bLength = sc.nextInt();

        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();

        for (int i = 0; i < aLength; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < bLength; i++) {
            b.add(sc.nextInt());
        }

        int ans = 0;

        int aAve = ave(a);
        int bAve = ave(b);

        while (aAve > bAve && a.size() > 0 && b.size() > 0 ) {
            int index = find(a, aAve, bAve);
            if (index == -1) break;
            a.remove(index);
            b.add(index);
            ans++;
            aAve = ave(a); bAve = ave(b);
        }
        while (bAve > aAve && a.size() > 0 && b.size() > 0 ) {
            int index = find(b, bAve, aAve);
            if (index == -1) break;

            b.remove(index);
            a.add(index);
            ans++;
            aAve = ave(a); bAve = ave(b);
        }
        System.out.println( ans);
    }

    private static int find(List<Integer> list, int selfAve, int otherAve) {
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur > otherAve && cur <= selfAve) {
                return i;
            }
        }
        return -1;
    }

    private static int min(List<Integer> list) {
        int min = list.get(0);
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static int ave(List<Integer> list) {
        int ave = 0;
        for (int i : list) {
            ave += i;
        }
        return ave/list.size();
    }
}
