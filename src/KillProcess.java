import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mingyama on 8/31/17.
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (pid.size() != ppid.size()) return new LinkedList<>();
        Queue<Integer> parents = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        parents.add(kill);

        while (!parents.isEmpty()) {
            Integer cur = parents.poll();
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) == cur) {
                    parents.add(pid.get(i));
                }
            }
            res.add(cur);
        }

        return res;
    }


}
