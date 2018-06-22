package Tree;
import java.util.*;
/**
 * Created by mingyama on 10/12/17.
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        for (List<Integer> value : map.values()) {
            double average = 0.0;
            for (int i : value) {
                average += i;
            }
            average /= (double) value.size();
            res.add(average);
        }
        return res;
    }

    private void dfs(TreeNode root, HashMap<Integer, List<Integer>> map, int level) {
        if (root == null ) return;
        if (map.keySet().size() == level) {
            map.put(level, new LinkedList<>());
        }

        map.get(level).add(root.val);
        dfs(root.left, map, level+1);
        dfs(root.right, map, level+1);
    }
}
