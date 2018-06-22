package OA;

/**
 * Created by mingyama on 2/27/18.
 */
public class KEmptySlots {
    //flowers: [1,2,3]
// k: 1
// Output: -1

    //1 -> x,o,o
    //1,2 -> x,x,o
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length < k + 1) return -1;
        int N = flowers.length;
        int[] f = new int[N+1];
        for (int i = 0; i < N; i++) {
            int pos = flowers[i]; // bloom at ith day in x position
            f[pos] = 1;
            if (isValid(f, pos, N, k)) return i+1;
        }
        return -1;
    }

    private boolean isValid(int[] f, int pos, int N, int k) {
        // int flag = false;
        int i = 0;
        if (pos + 1 + k <= N && f[pos + 1 + k] == 1) {
            for (i = pos+1; i < pos + k + 1; i++) {
                if (f[i] == 1) break;
            }
            if (i == pos + k + 1) return true;
        }
        if (pos-1-k > 0 && f[pos-1-k] == 1) {
            for (int j = pos-k; j < pos; j++) {
                if (f[j] == 1) return false;
            }
            return true;
        }
        return false;
    }

    public int kEmptySlotsTwisted(int[] flowers, int k) {
        if (flowers == null) return -1;
        int N = flowers.length;
        int[] f = new int[N+1];

        for (int i = 0; i < N; i++) {
            int pos = flowers[i]; // 最后一天开花的position
            f[pos] = 1;
            if (valid(f, pos, k)) {
                return i+1;
            }
//            f[pos] = 0;
        }
        return -1;
    }

    private boolean valid(int[] f, int pos, int k) {
        int N = f.length;
        int i = pos- k;
        for (; i <= pos; i++) { // i is the starting point
            int temp = i;
            while (temp < i + k + 2 && temp < N && temp > 0) {
                if (f[temp] == 0) break;
                temp++;
            }
            if (temp == i + k + 2) return true;
        }
        return false;
    }

    public int solution(int[] P, int K) {
        // write your code in Java SE 8
        int len = P.length;
        int[] f = new int[len+1];
        int res = -1;
        for (int i = 0; i < len; i++) {
            int pos = P[i];
            f[pos] = 1;
            if (checkValid(f, K, pos)) {
                res = i + 1;
            }
        }
        return res;
    }

    private boolean checkValid(int[] f, int K, int pos) {
        int i = 1; // i is the starting point
        int N = f.length;
        // check left and right bound for addend flowers

        for (; i < N; i++) {
            if ( i > 1 && f[i] == 1 && f[i-1] == 1) continue;
            if (i+K < N && f[i+K-1] == 1 && f[i+K] == 1) continue;
            if (i < 1) continue;
            int counter = i;
            while (counter < i + K && counter < N) { //count until i + K - 1 for K flowers
                if (f[counter] != 1) break;
                counter++;
            }
            if (counter == i + K && (counter == N || f[counter] == 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KEmptySlots().solution(new int[]{3,1,5,4,2}, 1));
        System.out.println(new KEmptySlots().solution(new int[]{3,1,5,4,2}, 2));
        System.out.println(new KEmptySlots().solution(new int[]{3,1,5,4,2}, 3));
        System.out.println(new KEmptySlots().solution(new int[]{3,1,5,4,2}, 4));
        System.out.println(new KEmptySlots().solution(new int[]{3,1,5,4,2}, 5));
    }

}
