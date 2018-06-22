package Tree;
import java.util.*;
/**
 * Created by mingyama on 10/25/17.
 */
public class CloneGraph {
    public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        public UndirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode dummy = new UndirectedGraphNode(node.label);
        map.put(node.label, dummy);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();

            for (UndirectedGraphNode n : cur.neighbors) {
                if (!map.containsKey(n.label)) {
                    queue.offer(n);
                    map.put(n.label, new UndirectedGraphNode(n.label));
                }
                map.get(cur.label).neighbors.add(map.get(n.label));
            }
        }

        return dummy;
    }

    public UndirectedGraphNode cloneGraphRecursive(UndirectedGraphNode node) {
        return null;
    }


}
