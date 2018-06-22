public class MultiplyQuestion {
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
        for (int i = len-1; i>= 0; i--) {
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

    public static void main(String[] args) {
        MultiplyQuestion mq = new MultiplyQuestion();
        for (int i : mq.solution(new int[] {1,2,3,4,5})) {
            System.out.print(i + " " );
        }
        System.out.println(~123);
        System.out.println(123);
    }

    // test output:
    // 120 60 40 30 24

}
