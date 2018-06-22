package FB;
import java.util.*;
/**
 * Created by mingyama on 10/26/17.
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();

        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new LinkedList<>());
            }
            map.get(sorted).add(cur);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
