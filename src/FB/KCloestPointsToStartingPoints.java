package FB;
import java.util.*;
/**
 * Created by mingyama on 10/28/17.
 */
public class KCloestPointsToStartingPoints {
    public List<int[]> findPoints(int[][] points, int[] startPoint, int k) {
        if (points == null || points.length == 0) return null;

        PriorityQueue<int[]> queue = new PriorityQueue<>(points.length, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                double d1 = Math.sqrt(Math.pow(i1[0] - startPoint[0], 2) + Math.pow(i1[1]-startPoint[1], 2));
                double d2 = Math.sqrt(Math.pow(i2[0] - startPoint[0], 2) + Math.pow(i2[1]-startPoint[1], 2));
                if (d1 > d2) return 1;
                else if (d1 < d2) return -1;
                return 0;
            }
        });
        for (int[] point : points) {
            queue.offer(point);
        }
        int i = 0;
        List<int[]> list = new LinkedList<>();
        while ( i < k) {
            list.add(queue.poll());
            i++;
        }
        return list;
    }

    public static void main(String[] a) {
        int[] p1 = {1,2};
        int[] p3 = {2,3};
        int[] p2 = {4,6};
        int[] p4 = {7,9};
        int[][] points = {p1, p2, p3, p4};
        int[] start = {2,2};
        for (int[] res : new KCloestPointsToStartingPoints().findPoints(points, start, 2)) {
            System.out.printf("%d, %d\n", res[0], res[1]);
        }

    }
}
