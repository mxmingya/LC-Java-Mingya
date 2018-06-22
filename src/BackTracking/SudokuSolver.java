package BackTracking;

/**
 * Created by mingyama on 9/25/17.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (backtrack(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != '.' && board[i][column] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
        }
        // check 3*3 block if available
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row / 3 + row % 3 + i][column / 3 + column % 3 + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] test = new String[] {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] input = new char[9][9];
        for (int i = 0; i < 9; i++) {
            input[i] = test[i].toCharArray();
        }
        new SudokuSolver().solveSudoku(input);
        for (char[] chars : input) {
            for (char c : chars) {
                System.out.printf("%c", c);
            }
            System.out.println("");
        }

    }
}
