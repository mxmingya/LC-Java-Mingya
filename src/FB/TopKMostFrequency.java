package FB;
import java.util.*;
/**
 * Created by mingyama on 10/18/17.
 */
public class TopKMostFrequency {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length ==0) return res;
        Map<Integer, Integer> intToCount = new HashMap<>();
        for (int i : nums) {
            intToCount.put(i, intToCount.getOrDefault(i, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for (int key : intToCount.keySet()) {
            int freq = intToCount.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);

        }
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null)
                System.out.printf("%d, %d\n", i, buckets[i].size());
        }
        for (int i = buckets.length-1; i >= 0; i--) { //list
            if (buckets[i] != null) {
                if (res.size() >= k) break;
                for (int num : buckets[i]) {
                    if (res.size() >= k) break;
                    res.add(num);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TopKMostFrequency().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }
}
