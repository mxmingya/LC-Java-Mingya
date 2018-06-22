/**
 * Created by mingyama on 10/16/17.
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m =matrix.length, n = matrix[0].length;
        boolean first_row = false, first_col = false;
        // int row =0, col = 0;
        for (int row = 0; row < m ; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0 ) {
                    if (row == 0) {
                        first_row = true;
                    }
                    if (col == 0) {
                        first_col = true;
                    }
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (first_row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (first_col) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] a) {

    }
}
