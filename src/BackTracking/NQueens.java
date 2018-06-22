package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/28/17.
 */
public class NQueens {
//    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//    Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//    For example,
//    There exist two distinct solutions to the 4-queens puzzle:
//            [
//            [".Q..",  // Solution 1
//            "...Q",
//            "Q...",
//            "..Q."],
//
//            ["..Q.",  // Solution 2
//            "Q...",
//            "...Q",
//            ".Q.."]
//            ]

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        Map<Integer, Integer> positions = new HashMap<>();
        dfs(n, positions, res);
        return res;
    }

    private void dfs(int n, Map<Integer, Integer> positions, List<List<String>> res) {
        if (positions.keySet().size() == n) {
            // construct plate and add it to results list
            List<String> holder = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int val = positions.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == val) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                holder.add(sb.toString());
            }
            res.add(holder);
            return;
        } else if (res.size() == n) return;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (valid(positions, i, j)) {
//                    System.out.printf("been here: i=%d, j=%d \n", i,j);
                    positions.put(i, j);
                    dfs(n, positions, res);
                    positions.remove(i);
                }
            }
        }
    }

    private boolean valid(Map<Integer, Integer> positions, int i, int j) {
        for (Integer key : positions.keySet()) {
            if (key == i || positions.get(key) == j) return false; //row and column
            if (key - i == Math.abs(positions.get(key)-j)) return false; // check diagonal
        }
        return true;
    }

        public List<List<String>> solveNQueens__works(int n) {
            char[][] board = new char[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    board[i][j] = '.';
            List<List<String>> res = new ArrayList<List<String>>();
            dfs(board, 0, res);
            return res;
        }

        private void dfs(char[][] board, int colIndex, List<List<String>> res) {
            if(colIndex == board.length) {
                res.add(construct(board));
                return;
            }

            for(int i = 0; i < board.length; i++) {
                if(validate(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    dfs(board, colIndex + 1, res);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean validate(char[][] board, int x, int y) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < y; j++) {
                    if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                        return false;
                }
            }

            return true;
        }

        private List<String> construct(char[][] board) {
            List<String> res = new LinkedList<String>();
            for(int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                res.add(s);
            }
            return res;
        }
    public static void main(String[] args) {
        List<List<String>> res = new NQueens().solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%s \n", res.get(j));
            }
            System.out.println("---------------------");
        }
        System.out.printf("%d", res.size());
    }
}
