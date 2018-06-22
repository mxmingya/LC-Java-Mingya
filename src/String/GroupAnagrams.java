package String;
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //利用string可以变成chararray的基础上去sort这个string，
        // anagram的题的另一种做法就是存下所有的char出现的次数在一个hashmap里面
        // String题的另一种做法。
        if (strs == null || strs.length == 0) return null;
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String nStr = new String(chars);
            if (!map.containsKey(nStr)) {
                map.put(nStr, new LinkedList<>());
            }
            map.get(nStr).add(str);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
