package OA.YelpOA;
import java.io.*;
import java.util.*;

public class YelpPhoneInterview {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

/*

Create method that will check to see if 2 strings are anagrams of each other
Example:
"looped", "poodle" = true
"heater", "reheat" = true
"dog", "fog" = false

*/


        private boolean isAnagram(String word1, String word2) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            if (word1.length() != word2.length()) return false;
            for (char c : word1.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0)+1);
            }
            for (char c : word2.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0)+1);
            }
            for (char c : word1.toCharArray()) {

                int count1 = map1.get(c);
                if (!map2.containsKey(c)) {
                    return false;
                }
                int count2 = map2.get(c);
                if (count1 != count2) return false;
            }
            return true;
        }

  /*

  Given an array of strings, only return back strings that are anagrams in the same order:
"hello", "loop", "car", "tea", "pool", "eat", "world"
->
"loop", "tea", "pool", "eat"

  */

        private List<String> findAnagram(List<String> list) {
            if (list == null || list.size() == 0) return null;
            List<List<String>> res = new LinkedList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String word : list) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);

                if (!map.containsKey(sorted)) {
                    map.put(sorted, new LinkedList<>());
                }

                List<String> strs = map.get(sorted);
                strs.add(word);

            }
            for (String key : map.keySet()) {
                res.add(map.get(key));
            }
            List<String> ret = new LinkedList<>();
            for (String word : list) {
                List<String> l = map.get(word);
                if (l.size() != 1) {
                    ret.add(word);
                }
            }
            return ret;
        }


            public static void main(String[] args) {
                YelpPhoneInterview s1 = new YelpPhoneInterview();
                System.out.println(s1.isAnagram("looped", "poodle"));
                System.out.println(s1.isAnagram("heater", "reheat"));
                System.out.println(s1.isAnagram("dog", "fog"));
                List<String> res = new LinkedList<>();
                res.add("tea");

                res.add("car");
                res.add("hello");
                res.add("loop");
                res.add("world");
                res.add("eat");
                res.add("pool");
                List<String> ret = s1.findAnagram(res);
            }


}
