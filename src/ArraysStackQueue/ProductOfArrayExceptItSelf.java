package ArraysStackQueue;

public class ProductOfArrayExceptItSelf {

    public int[] solution(int[] arr) {
        int len = arr.length;
        int[] leftToRight = new int[arr.length];

        int productLeft = 1;
        for (int i = 0; i < len; i++) {
            productLeft = arr[i] * productLeft;
            leftToRight[i] = productLeft;
        }

        int[] rightToLeft = new int[len];
        int productRight = 1;
        for (int i = 0; i < len; i++) {
            productRight *= arr[i];
            rightToLeft[i] = productRight;
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if ( i == 0) {
                answer[i] = rightToLeft[1];
            }
            else if (i == len-1) {
                answer[i] = leftToRight[i-1];
            }
            else {
                answer[i] = leftToRight[i-1] * rightToLeft[i+1];
            }
        }
        return answer;
    }

}
