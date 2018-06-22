package FB;
import java.util.*;
/**
 * Created by mingyama on 10/21/17.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // AAABBC, n = 2
        // A--A--A
        // AB-AB-A
        // ABCAB-A
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c-'A']++;
        }
//        for (int i : counts)
//            System.out.printf("%d, ", i);
        Arrays.sort(tasks);
        for (int i : counts)
            System.out.printf("%d, ", i);
        int max = counts[25];
        System.out.printf("max : %d\n", max);
        int i = 25;
        while( i >= 0 && counts[i] == max) i--;
        return Math.max(tasks.length, (max-1)*(n+1)+25-i);
    }

    public int leastInterval_myversion(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c-'A']++;
        }
        // ArraysStackQueue.sort(counts);
        // int max = counts[25];
        int max = 0;
        for (int i : counts) {
            max = Math.max(i, max);
        }
        System.out.printf("max is %d\n", max);
        int i = 0;
        for (int k : counts) {
            if (k == max) i++;
        }
        System.out.printf("i is %d\n", i);
        // int i = 25;
        // for (; i >= 0 && counts[i] == max; i--);
        return Math.max(tasks.length, (max-1)*(n+1)+i);
    }

    public static void main(String[] a) {
        System.out.println(new TaskScheduler().leastInterval_myversion(new char[] {'A', 'A', 'A', 'B', 'B','B'}, 2));
    }
}
