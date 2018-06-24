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

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] res = new int[nums.length];
        int multi = 1;
        int zero = 0;
        for (int num : nums) {
            if (num != 0) {
                multi *= num;
            } else {
                zero += 1;
            }
        }
        if (zero > 1) return res;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = multi;
            }  else if (zero == 1) {
                res[i] = 0;
            } else {
                res[i] = multi / nums[i];
            }
        }
        return res;
    }

}
