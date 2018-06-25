package ArraysStackQueue.matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // < 2 died
        // 2-3 to next
        // > 3 died
        // dea with 3 becomes alive
        // 0 died -> dead, 1 live -> live, 2 live -> dead, 3 dead -> live
        if (board == null || board.length == 0) return;
        // 0 1 0
        // 0 0 1
        // 1 1 1
        // 0 0 0
        int m = board.length, n = board[0].length;
        int[] x = {-1,-1,-1,0,0,1,1,1};
        int[] y = {-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int counter = 0;
                for (int k = 0; k < 8; k++) {
                    int row = i+x[k], col =j+ y[k];
                    if (row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 1 || board[row][col] == 2)) {
                        counter++;
                    }
                }
                if (board[i][j] == 0 && counter == 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (counter > 3 || counter < 2) ) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
