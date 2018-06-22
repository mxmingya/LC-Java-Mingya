package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/27/17.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
//        Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//                For example:
//        Given "25525511135",
//
//        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        int numOfDots = 0;
        backtrack(s, res, numOfDots, 0);
        return res;
    }

    private void backtrack(String s, List<String> res, int numOfDots, int start) {
        if (numOfDots == 3 && isValid(s)) {

        }
    }

    private boolean isValid(String ip) {
        int len = ip.length();
        if (len < 4 || len > 15) return false;
        String[] ips = ip.split("\\.");
        if (ips.length != 4) return false;
        for (String s : ips) {
            if (s.length() <= 0 || s.length() >4) return false;
            for (Character c : s.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
        }
        return true;
    }


}
