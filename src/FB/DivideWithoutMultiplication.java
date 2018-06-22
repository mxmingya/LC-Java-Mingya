package FB;

/**
 * Created by mingyama on 10/30/17.
 */
public class DivideWithoutMultiplication {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;

        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;

        int m = Math.abs(dividend), n = Math.abs(divisor);

        int res = 0;
        int cur = divisor;
        while (cur < dividend) {
            if (dividend < (cur << 1) && dividend > cur) {

            }
        }

        return 0;
    }
}
