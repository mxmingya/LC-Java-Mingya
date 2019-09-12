class Pow50 {
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                return 1 / helper(x, -n);
            }
            return helper(x, n);
        }
        
        public double helper(double x, int n) {
            // base case
            if (n == 0) {
                return 1;
            }
            // how recursion work: 
            double val = helper(x, n/2);
            return n % 2 == 0 ? val *  val : x *  val *  val;
        }
    }
}