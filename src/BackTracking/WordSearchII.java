package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/28/17.
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (String word : words) {
                    if (dfs( board, word, i, j, 0) && !res.contains(word)) {
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs( char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        board[i][j] ^= 256; // mark as visited
        boolean search = dfs(board, word, i+1, j, index+1) ||
                dfs(board, word, i, j+1, index+1) ||
                dfs(board, word, i-1, j, index+1) ||
                dfs(board, word, i, j-1, index+1);
        board[i][j] ^= 256;
        return search;
    }

    public static void main(String[] args) {
        String[] lol = new String[] {"oaan","etae","ihkr","iflv"};
        char[][] input = new char[lol.length][lol[0].length()];
        for (int i = 0; i < lol.length; i++) {
            input[i] = lol[i].toCharArray();
        }
        for (String s : new WordSearchII().findWords(input ,new String[] {"oath","eat","eat","rain"})) {
            System.out.println(s);
        }
    }
}
