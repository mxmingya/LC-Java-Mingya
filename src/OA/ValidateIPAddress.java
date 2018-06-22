package OA;
import java.util.*;
/**
 * Created by mingyama on 9/26/17.
 */
public class ValidateIPAddress {
    public static String[] checkIP(String[] ip) {
        String[] answer = new String[ip.length];
        for (int i = 1; i < ip.length; i++) {
            if (IPv4(ip[i])) answer[i] = "IPv4";
            else if (IPv6(ip[i])) answer[i] = "IPv6";
            else {
                answer[i] = "Neither";
            }
        }
        return answer;
    }

    private static boolean IPv4(String ip ) {
        if (ip.length() < 7) return false;
        if (ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.') return false;
        String[] section = ip.split("\\.");
        if (section.length != 4) {
            return false;
        }
        for (String str : section) {
            if (str.length() == 0 || str.length() > 3) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            if (str.charAt(0) == '0' && str.length() > 1) {
                return false;
            }
            if (!str.startsWith("0") && Integer.parseInt(str) == 0) return false;
            if (Integer.parseInt(str) > 255 || Integer.parseInt(str) < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean IPv6(String ip ) {
        String[] section = ip.split(":");
        if (section.length != 8) return false;
        for (String str : section) {
            if (str == null || str.length() > 4 || str.length() == 0) return false;
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c) && !Character.isAlphabetic(c)) return false;
            }
        }
        return true;
    }

    public static void main(String[] a) {
        for (String s : checkIP(new String[]{"3", "This line has junk text.", "172.16.254.1","2001:0db8:85a3:0000:0000:8a2e:0370:7334"})) {
            System.out.println(s);
        }
    }
}
