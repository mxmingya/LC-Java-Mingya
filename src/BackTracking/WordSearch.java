package BackTracking;

/**
 * Created by mingyama on 9/28/17.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word.toCharArray(), i,j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[]word, int i, int j, int index) {
        if (index == word.length) {
            System.out.printf("index: %d too long\n", index);
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ) {
            System.out.printf("i:%d j%d\n", i, j);
            return false;
        }

        if (board[i][j] != word[index]) {
            System.out.printf("%s doesnt match %s\n", board[i][j], word[index]);
            return false;
        }
        board[i][j] ^= 256;
        boolean search = dfs(board, word, i+1, j, index+1)||
            dfs(board, word, i, j+1, index+1)||
            dfs(board, word, i-1, j, index+1)||
            dfs(board, word, i, j-1, index+1);
        board[i][j]^= 256;
        return search;
    }

    public static void main(String[] args) {
//        String[] lol = {"ABCE","SFCS","ADEE"};
        String[] lol = {"aa"};
//        String[] lol = {"a"};
        char[][] input = new char[lol.length][lol[0].length()];
        for (int i = 0; i < lol.length; i++) {
            input[i] = lol[i].toCharArray();
        }
//        System.out.println(new WordSearch().exist(input, "ABCCED"));
//        System.out.println(new WordSearch().exist(input, "ABCCEDDD"));
        System.out.println(new WordSearch().exist(input, "aaa"));
//        System.out.println(new WordSearch().exist(input, "ab"));
    }
}
