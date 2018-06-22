package OA;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/8/17.
 */
public class Foobar1 {
    public static String answer(int n) {

        //      Your code goes here.
        // generate prime number until 500
        // int[] primes
        StringBuilder sb = new StringBuilder();

        List<Integer> primeNumbers = new LinkedList<>();
        primeNumbers.add(2);
        sb.append("2");
        int cur = 3;
        while (sb.length() < 10005) {
            // generate all prime numbers under 1000
            boolean flag = true;
            for (int prime : primeNumbers) {
                if (cur % prime == 0) {
                    flag = false;
                    break;
                }
            }

            // if all prime numbers are not factors of cur, add cur to list, append it to string
            if (flag) {
                sb.append(cur);
                primeNumbers.add(cur);
            }
            cur++;
        }
        return sb.substring(n, n+5);
    }

    public static void main(String[] a) {
        System.out.println(Foobar1.answer(0));
        System.out.print(Foobar1.answer(3));
    }

}
