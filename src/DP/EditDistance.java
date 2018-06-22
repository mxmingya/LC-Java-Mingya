package DP;

/**
 * Created by mingyama on 9/16/17.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        /* first, we use a 2d dp arrays to record how many steps away from word1[0-i] to convert to word2[0-j]
        for the same s[i] == t[j], just assign from previous, but for the s[i] != s[j], get the min(delete, replace, add)
        somehow I feel like dp are same to recursion. you just believe it works, and it will work
        */
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // stands for the steps needed to convert empty string to this substrings
        for (int i = 0; i < dp.length; i++) {dp[i][0] = i;}
        for (int j = 0; j < dp[0].length; j++) {dp[0][j] = j;}

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = min(dp[i][j], dp[i+1][j], dp[i][j+1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private int min(int a, int b, int c) {return Math.min(a,Math.min(b,c));}

    public static void main(String[] a) {System.out.println(new EditDistance().minDistance("abcde","azdg"));}
}
