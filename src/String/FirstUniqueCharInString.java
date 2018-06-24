package String;
import java.util.*;

public class FirstUniqueCharInString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        // int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char cur = arr[i];
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        for (char c : arr) {
            if (map.get(c) == 1) return s.indexOf(c);
        }
        return -1;
    }
}
