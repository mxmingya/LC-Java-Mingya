package BackTracking;

import java.util.*;

/**
 * Created by mingyama on 9/29/17.
 */
public class NQueensII {
    public int totalNQueens(int n) {
        //return the number of solutions
        char[][] board = constructBoard(n);
        int[] counter = new int[1];
        backtracking(board, n, counter,0,0);
        return counter[0];
    }

    private void backtracking(char[][] board, int n, int[] counter, int row, int column) {
        if (row == n-1 && column == n-1) {
            counter[0]++;
            return;
        }

        for (int i = row; i < n; i++) {
            for (int j = column; j < n; j++) {
                if (board[i][j] == '.') {
                    if (isValid(board, i, j, n)) {
                        board[i][j] = 'Q';
                        backtracking(board, n, counter,i,j);
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    private int numOfQueens(char[][] board) {
        int num = 0;
        for (int i =0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') num++;
            }
        }
        return num;
    }
    private boolean isValid(char[][] board, int row, int column, int n) {
        for (int k = 0; k < n; k++) {
            if (board[row][k] == 'Q') return false;
            if (board[k][column] == 'Q') return false;

            //012345678 (2,2)=> (1,1) (3,3) 0,2 1,1 3,0
            //01Q.....
            //........
        }
        // diagonal
        for (int i =0; i<n;i++) {
            for (int j =0; j<n;j++) {
                if (Math.abs(i-row) == Math.abs(j-row) || Math.abs(i+row) == Math.abs(j+column)) {
                    if (board[i][j] == 'Q') return false;
                }
            }
        }
        return true;
    }

    private char[][] constructBoard(int n ) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }
    public static void main(String[] args) {
        System.out.printf("%d", new NQueensII().totalNQueens(4));
    }
}
