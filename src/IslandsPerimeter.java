/**
 * Created by mingyama on 10/8/17.
 */
import java.util.*;

public class IslandsPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;

        Map<Integer, Integer> visited= new HashMap<>();
        int neighbors = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // check if there are right or down neighbors
                    if (visited.containsKey(i) && visited.get(i) == j+1) neighbors++;
                    if (visited.containsKey(i+1) && visited.get(i+1) == j ) neighbors++;
                    visited.put(i,j);
                }
            }
        }
        return visited.keySet().size() * 4 - neighbors * 2;
    }
}
