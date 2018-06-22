package ArraysStackQueue;

/**
 * Created by mingyama on 10/6/17.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 1) return false;
        if (n % 2 == 1) return false;
        while (n > 2) {
            n /= 2;
        }
        return n == 2;
    }
}
