/**
 * Created by mingyama on 10/3/17.
 */
import java.util.*;
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        String[] mins = new String[] {"00","01", "02", "04", "08", "16", "32"};
        String[] hours = new String[] {"1", "2", "4", "8"};
        List<String> res = new LinkedList<>();
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        backtrack(res, num, new StringBuilder(), mins, hours);
        return res;
    }

    private void backtrack(List<String> res, int num, StringBuilder cur, String[] mins, String[] hours) {
        // base case
        if (cur.length() == num) {
            res.add(cur.toString());
            return;
        }

        for (int i = 0; i < hours.length; i++) {
            cur.append(hours[i]).append(":");
            for (int j = 0; j < mins.length; j++) {
                cur.append(mins[j]);
                backtrack(res, num, cur, mins, hours);
                cur.deleteCharAt(cur.length()-1);
                cur.deleteCharAt(cur.length()-1);
            }
            backtrack(res, num, cur, mins, hours);
            cur.deleteCharAt(cur.length()-1);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public List<String> readBinaryWatch_works(int num) {
        List<String> res = new LinkedList<>();
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++ ) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }



    public void main(String[] args) {
        for (String s : new BinaryWatch().readBinaryWatch(3)) {
            System.out.printf("%s ", s);
        }
    }
}
