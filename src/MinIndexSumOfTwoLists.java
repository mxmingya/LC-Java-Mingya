/**
 * Created by mingyama on 10/3/17.
 */
import java.util.*;
public class MinIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> resToIndex = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list2[j].equals(list1[i])) {
                    resToIndex.put(list1[i], i+j);
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        for (int i : resToIndex.values()) {
            minTime = Math.min(minTime, i);
        }
        List<String> res = new LinkedList<>();
        for (String s : resToIndex.keySet()) {
            if (resToIndex.get(s) == minTime) {
                res.add(s);
            }
        }
        String[] res2 = new String[res.size()];
        for (int i =0;i<res.size();i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }
}
