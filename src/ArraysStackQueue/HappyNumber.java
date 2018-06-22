package ArraysStackQueue;
import java.util.*;
/**
 * Created by mingyama on 10/6/17.
 */
public class HappyNumber {
    public boolean isHappy_(int n) {
        if (n == 0) return false;
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (n > 1) {
            int temp = 0;
            for (int digit : getDigits(n)) {
                temp += digit*digit;
            }
            System.out.printf("%d ", temp);
            if (visited.contains(temp)) {
                System.out.printf("because %d indicates a loop\n", n);
                return false;// loop founded
            }
            visited.add(temp);
            n = temp;
        }
        return true;
    }
    private List<Integer> getDigits(int n) {
        List<Integer> digits = new LinkedList<>();
        while (n >= 1) {
            int currentDigit = n % 10;
            digits.add(currentDigit);
            n /= 10;
        }
        return digits;
    }

    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                System.out.printf("%d, ", squareSum);
                n = squareSum;

        }
        return false;

    }
    public static void main(String[] a) {
        System.out.println(new HappyNumber().isHappy_(7));
        System.out.printf("-------------------------");
        System.out.println(new HappyNumber().isHappy(7));
    }

}
