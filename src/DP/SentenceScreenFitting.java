package DP;

/**
 * Created by mingyama on 9/13/17.
 */
public class SentenceScreenFitting {
    // workable solution but not optimal
    public int wordsTypingBruteForce(String[] sentence, int rows, int cols) {
        int startWordIndex = 0;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int curWordIndex = startWordIndex;
            int colIndex = 0;
            while (colIndex < cols) {
                if (sentence[curWordIndex].length() + colIndex > cols) {
                    System.out.println("break here");
                    break;
                }
                else {
                    System.out.printf("%s ", sentence[curWordIndex]);
                    System.out.printf("colIndex is: %d: ", colIndex);
                    if (curWordIndex == sentence.length - 1) {
                        res++;
                        colIndex += sentence[curWordIndex].length() + 1;
                        curWordIndex = 0;
                    } else {
                        colIndex += sentence[curWordIndex].length() + 1;
                        curWordIndex++;
                    }
                    System.out.printf("index after updated: %d \n", colIndex);
                }
            }
            if (res >= 1) {

            }
            startWordIndex = curWordIndex;
        }
        return res;
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        // for this method, we consider the matrix with row and col as a long array that have row numbers of array with length of col.
        // (concat all the columns together to a long row)
        // then we check what part of the string could fit to the current 'col'. and then startPositionOfString should be the total number of
        // char arrays block we have used. [''].
        // divide the input string length to compute the number of string that we can fit. and this is so smart.
        String s  = String.join(" ", sentence) + " ";

        int len = s.length();
        int startPositionOfString = 0;
        for (int i = 0 ; i < rows; i++) {
            startPositionOfString += cols;
            if (s.charAt(startPositionOfString % len) == ' ') startPositionOfString++;/// means the string positions just fit the whole string perfectly
            else while (startPositionOfString > 0 && s.charAt((startPositionOfString - 1) % len) != ' ') startPositionOfString--; // track back to find the first index of empty space in current row
        }
        return startPositionOfString / len;
    }


    public static void main(String[] a) {
        System.out.println(new SentenceScreenFitting().wordsTyping(new String[] {"hello","world"},
                2,
                8));
        System.out.println(new SentenceScreenFitting().wordsTyping(new String[] {"a", "bcd", "e"},4, 6));
        System.out.println(new SentenceScreenFitting().wordsTyping(new String[] {"a", "bcd", "e"}, 4,6));
        System.out.println(new SentenceScreenFitting().wordsTyping(new String[] {"I", "had", "apple", "pie"}, 4,5));
        System.out.println(new SentenceScreenFitting().wordsTyping(new String[] {"try","to","be","better"},10000,  9001));
    }
}
