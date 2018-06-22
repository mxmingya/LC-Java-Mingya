package FB;
import java.util.*;
/**
 * Created by mingyama on 10/26/17.
 */
public class findCelebrity {
    public int findCelebrity(int n) {
        if (n == 0) return 0;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (!map.containsKey(i)) {
                    map.put(i, new HashSet<>());
                }
                if (knows(i, j)) {
                    map.get(i).add(j);
                }
            }
        }
        List<Integer> peopleWhoKnowsNoOne= new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key).size() == 0) peopleWhoKnowsNoOne.add(key);
        }
        for (int people : peopleWhoKnowsNoOne) {
            boolean flag = false;
            for (int key : map.keySet()) {
                if (key == people) continue;
                HashSet<Integer> set = map.get(key);
                if (!set.contains(people)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return people;
            }
        }
        return -1;
    }

    public int findCelebrity_fast(int n) {
        if (n < 0) return -1;

        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!knows(i, celebrity)) {
                return -1;
            }
        }
        return -1;
    }

    private boolean knows(int i, int j) {
        return false;
    }
}
