package String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(left))+1);
            }
            map.put(s.charAt(i), i);
            max = max > i-left+1 ? max : i-left+1;
        }
        return max;
    }
}
