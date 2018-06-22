//package BackTracking;
//import java.util.*;
///**
// * Created by mingyama on 10/2/17.
// */
//public class WordLadderII {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new LinkedList<>();
//        List<String> current = new LinkedList<>();
//        current.add(beginWord);
//        Set<String> visited = new HashSet<>();
//        backtrack(endWord, wordList, res, current, visited);
//        return res;
//    }
//
//    private void backtrack(String endWord, List<String> wordList, List<List<String>> res, List<String> current, Set<String> visited) {
//        if (res.size() > 0 && current.size() > res.get(0).size() ) return;
//
//        if (current.size() > 0 && current.get(current.size()-1).equals(endWord)) {
//           if (res.contains(current)) return;
//           if (res.size() > 0 && current.size() < res.get(0).size()) {
//               res.clear();
//           }
//           res.add(new LinkedList<>(current));
//           return;
//        }
//        for (int i = 0; i < wordList.size(); i++) {
//            String cur = wordList.get(i);
//            if (visited.contains(cur)) continue;
//            if (current.size() > 0 && !editDistance(cur, current.get(current.size()-1))) continue;
//            visited.add(cur);
//            current.add(cur);
//            backtrack(endWord, wordList, res, current, visited);
//            current.remove(current.size()-1);
//            visited.remove(cur);
//        }
//    }
//
//    private void build(String beginWord, List<String> wordList, Map<String, List<String>> map) {
//        // word => list of words this can change to
//        map.put(beginWord, new LinkedList<>());
//        for (int i = 0; i < wordList.size(); i++) {
//            String cur = wordList.get(i);
//            map.put(cur, new LinkedList<>());
//            for (String s : wordList) {
//                if ( editDistance(s, cur))
//                    map.get(cur).add(s);
//            }
//        }
//    }
//
//    public List<List<String>> findLadders_fast(String beginWord, String endWord, List<String> wordList) {
//
//        Set<String > visited = new HashSet<>();
//        visited.add(beginWord);
//        Map<String, List<String>> map = new HashMap<>();
//        map.put(beginWord, new LinkedList<>());
//        List<List<String>> res = new LinkedList<>();
//        build(beginWord, wordList, map);
//        int minLength = bfs(beginWord, endWord, wordList, visited, map);
//        List<String> current = new LinkedList<>();
//        current.add(beginWord)
//        return res;
//    }
//
//    private void dfs(String endWord, List<String> wordList, List<String> current, List<List<String>> res, int minLength, int step, Map<String, List<String>> map) {
//        if (current.size() > minLength) return;
//        if (current.size() > 0 && current.get(current.size()-1).equals(endWord) ) {
//            if (res.size() > 0 && res.get(0).size() > current.size()) {
//                res.clear();
//            }
//            if (res.size()> 0 && res.get(0).size() < current.size()) return;
//            res.add(new ArrayList<>(current));
//            return;
//        }
//        for (String s : map.get()) {
//
//        }
//
//    }
//
//    private int bfs(String beginWord, String endWord, List<String> wordList, Set<String> visited, Map<String, List<String>> map) {
//        int step = 1;
//        Queue<String> q = new LinkedList<>();
//        q.add(beginWord);
//        while (!q.isEmpty()) {
//            String cur = q.poll();
//            if (cur.equals(endWord)) return step;
//            if (map.get(cur) != null) {
//                for (String s : map.get(cur)) {
//                    if (editDistance(s, cur) && !visited.contains(s)) {
//                        q.offer(s);
//                        visited.add(s);
//                    }
//                }
//            }
//            step++;
//        }
//        return step;
//    }
//
//    private boolean editDistance(String s, String t) {
//        int count = 0;
//        for (int i = 0 ; i < s.length(); i++) {
//            if (s.charAt(i) != t.charAt(i)) count++;
//            if (count >= 2) return false;
//        }
//        return count <= 1;
//    }
//
//    public static void main(String[] args) {
//        for (List<String> strs : new WordLadderII().findLadders("hit", "cog", ArraysStackQueue.asList(new String[]{"hot","dot","dog","lot","log","cog"}))){
//            for (String s : strs) {
//                System.out.printf("%s ", s);
//            }
//            System.out.println();
//        }
//    }
//
//}
