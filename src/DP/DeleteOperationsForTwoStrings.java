package DP;

/**
 * Created by mingyama on 9/16/17.
 */
public class DeleteOperationsForTwoStrings {
    public int minDistance(String word1, String word2) {
        // find the minimum steps of deleting characters to make two strings identical
        // use a 2d dp array to record the minimum edit distance of word1.substring(0,i+1) && word2.substring(0,j+1)
        // find the longest common string
        // return the difference of two string lengths and the length of their longest common string
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) dp[i][j] = 0; // initial state, no previous sub problem to computed based on
                else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        int diff = dp[word1.length()][word2.length()];
        return word1.length() - diff + word2.length() - diff; // because we can only delete one char in either word each time
    }

    public static void main(String[] args) {
        System.out.println(new DeleteOperationsForTwoStrings().minDistance("eat", "sea"));
        System.out.println(new DeleteOperationsForTwoStrings().minDistance("eat", "seaa"));
    }
}
