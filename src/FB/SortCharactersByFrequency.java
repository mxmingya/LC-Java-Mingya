package FB;
import java.util.*;

/**
 * Created by mingyama on 10/17/17.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Character>[] buckets = new List[s.length()+1];
        for (char c : map.keySet()) {
            int frequency = map.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        for (int i = buckets.length-1; i>= 0; i--) {
            List<Character> chars = buckets[i];
            if (chars != null) {
                for (char c : chars) {
                    for (int j =0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
