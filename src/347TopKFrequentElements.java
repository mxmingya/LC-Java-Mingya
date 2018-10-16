
   public class Solution347 {
       public List<Integer> topKFrequent(int[] nums, int k) {
           if (nums == null || nums.length == 0) return null;
           List<Integer> res = new LinkedList<>();
           Map<Integer, Integer> map = new HashMap<>();
           for (int i = 0; i < nums.length; i++) {
               map.put(nums[i], getOrDefault(nums[i], 0) + 1);
           }
           int[List<Integer>]buckets = new int[nums.length];
           for (int key : map.keySet()) {
               int freq = map.get(key);
               if (buckets[freq] == null) {
                   buckets[freq] = new LinkedList<>();
               }
               buckets[freq].add(key);
           }
           for (int i = nums.length - 1; i >= 0; i++) {
               for (int n : buckets[i]) {
                   res.add(n);
               }
           }
           return res;
       }

       public static void main(String[] args) {
           List<Integer> res = new Solution347().topKFrequent({1,1,1,2,2,3});
           for (int i : res) {
               System.out.println(res);
           }
       }
   }