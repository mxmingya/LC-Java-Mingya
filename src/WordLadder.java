/**
 * Created by mingyama on 10/1/17.
 */
import BackTracking.WordSearch;

import java.util.*;
public class WordLadder {
    Map<String, List<String>> map = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        build(beginWord, wordList, map);
        for (String key : map.keySet()) {
            System.out.printf("%s\n", key);
            for (String s : map.get(key)) {
                System.out.printf("%s ", s);
            }
        }
        System.out.println(map.keySet().size());
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <size; i++) {
                String cur = queue.poll();
                System.out.println(cur);
                System.out.println(map.get(cur)==null);
                if (cur.equals(endWord)) return step;
                if (map.get(cur) != null) {
                    for (String s : map.get(cur)) {
                        if (!set.contains(s)) {
                            queue.add(s);
                            set.add(s);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private void build(String beginWord, List<String> wordList, Map<String, List<String>> words) {
        // construct a hash map of word => list of words that is 1 edit distance from word
        map.put(beginWord, new LinkedList<>());
        for (String s : wordList) {
            if (editDistance(s, beginWord) == 1) {
                map.get(beginWord).add(s);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            String cur = wordList.get(i);
            words.put(cur, new LinkedList<>());
            for (String s : wordList) {
                if (editDistance(s, cur) == 1) {
                    words.get(cur).add(s);
                }
            }
        }
    }

    private int editDistance(String s, String t) {
        // the length is the same
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) count++;
        }
        return count;
    }

    public static void main(String[] a) {
        String[] wordList = new String[] {
                "hot","dot","dog","lot","log","cog"
        };
        List<String> list = Arrays.asList(wordList);
        System.out.println(new WordLadder().ladderLength("hit", "cog", list));
    }
}
