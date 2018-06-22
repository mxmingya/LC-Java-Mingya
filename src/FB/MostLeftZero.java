package FB;

/**
 * Created by mingyama on 10/30/17.
 */
public class MostLeftZero {
    public int mostLeftZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int min = matrix[0].length-1;

        for (int i = 0; i < matrix.length; i++) {
            int j = min;
            while (matrix[i][j] == 0 && j >= 0) {
                j--;
            }
            min = j;
        }
        return min+1;
    }

    public static void main(String[] a) {
        int[] a1 = {1,1,1,0,0};
        int[] a2 = {1,1,0,0,0};
        int[] a3 = {1,0,0,0,0};
        int[] a4 = {1,1,0,0,0};
        System.out.println(new MostLeftZero().mostLeftZero(new int[][] {a1, a2, a3, a4}));
    }

}
