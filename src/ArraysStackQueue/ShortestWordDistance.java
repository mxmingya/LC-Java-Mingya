package ArraysStackQueue;

/**
 * Created by mingyama on 10/6/17.
 */
public class ShortestWordDistance {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDistance = 0;
        int pos1 = -1, pos2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (pos1 != -1 && word1.equals(word2)) {
                    minDistance = Math.min(minDistance, Math.abs(pos1 - i));
                    pos1 = i;
                } else {
                    pos1 = i;
                }
            }
            if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(pos1 - pos2));
            }
        }
        return minDistance;
    }
}
