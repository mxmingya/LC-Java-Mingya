package DP;

import java.util.Arrays;

/**
 * Created by mingyama on 9/16/17.
 */
public class DistinctSubsequence {
    public int numDistinct(String s, String t) {
        // use a 2D arrays to record number of distinct subsequence before dp[S[i]][T[j]]
        // the dp[0][j] and [i][0] means empty string is substring of T, and substring of empty string.
        // dp[i][j] = dp[i-1][j-1] + dp[i][j-1]: adding a character from s increase the number of subsequence in t or not.
        // depending on if the current character T[i-1] equals to S[j-1]
        // eg:
//              S = [acdabefbc]
//        mem[1] = [0111222222]
//              S = [acdabefbc]
//        mem[1] = [0111222222]
//        mem[2] = [0000022244]
        // as the loop goes: t='abcabc', s = 'abc'
        // for t = 'ab' how many 'abc' does it have
        // for t = 'abcab' how many 'abc' does it have
        if (s == null || t == null) return 0;
        int slen = s.length(), tlen = t.length();
        if (slen * tlen == 0) return 0;
        int[][] countOfSubSeq = new int[tlen+1][slen+1]; // stands for every
        Arrays.fill(countOfSubSeq[0], 1); // since "" is substring of every string
        for (int i = 0; i < tlen; i++) {
            for (int j = 0; j < slen; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    // countOfSubSeq[i][j] stands for before adding current char in T til last character in S,
                    // countOfSubSeq[i+1][j] stands for adding current char in S til current character
                    // eg: for substring of T in [0][j] how many subsequence of S[0][j] it has.
                    // incremental part is: countOfSubSeq[i+1][j].
                    countOfSubSeq[i+1][j+1] = countOfSubSeq[i][j]+countOfSubSeq[i+1][j];
                } else {
                    countOfSubSeq[i+1][j+1] = countOfSubSeq[i+1][j];
                }
            }
        }
        return countOfSubSeq[tlen][slen];
    }

    public int numDistinct_fromForum(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    public static void main(String[] a) {
        System.out.println(new DistinctSubsequence().numDistinct("abc","abcabc"));
        System.out.println(new DistinctSubsequence().numDistinct("c","ccc"));
        System.out.println(new DistinctSubsequence().numDistinct_fromForum("c","ccc"));
    }
}
