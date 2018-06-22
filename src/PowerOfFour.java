public class PowerOfFour {
    public boolean solution(int n) {
        // I assume the question means: determine if there exists a number x such that
        // x ^ 4 == n
        if (n == 1 || n == 0) return true; // 1 and 0 are the 4th power of 1 and 0

        return helper(n, n);
    }

    private boolean helper(int n, int x) {
        if (x == 1) return false; // if we go all the way down to 1 and didnt find any x that x ^ 4 is n, return false

        if (x * x * x * x == n) {
            return true;
        }

        return helper(n, x-1);
    }

    public static void main(String[] args) {
        System.out.println( new PowerOfFour().solution(16));
        System.out.println( new PowerOfFour().solution(8));
        System.out.println( new PowerOfFour().solution(4));
        System.out.println( new PowerOfFour().solution(4 * 4 * 4 * 4));

    }

}
