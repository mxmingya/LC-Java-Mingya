package OA;
import com.sun.media.jfxmedia.logging.Logger;

import java.util.*;
/**
 * Created by mingyama on 10/12/17.
 */
public class FindShortestPath {

    public int findPath(char[][] map) {
        // obstacle: b and houses: h , empty spot: .
        // visited have the distance from char[x][y] to all house
        // how do we know if we visited all the houses? reverse, start from the house, to the current place
        if (map == null || map.length == 0) return 0;
        int m = map.length, n = map[0].length;
        int[][] visited = new int[m][n];
        int minDistance = Integer.MAX_VALUE;
        List<List<Integer>> houses = new LinkedList<>();
        // find all the houses
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'h') {
                    List<Integer> house = new LinkedList<>();
                    house.add(i);
                    house.add(j);
                    houses.add(house);
                }
            }
        }
        if (houses.size() == 0) {
//            Logger.warning("INVALID MAP, NO HOUSE");
            return Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') { // available spot
                    int[] totalDistance = new int[] {0};
                    bfs(map, houses, totalDistance, 0, i, j);
                }
            }
        }

        return 0;
    }

    private void bfs(char[][] map, List<List<Integer>> houses, int[] totalDistance, int distance, int i, int j) {

    }
}
