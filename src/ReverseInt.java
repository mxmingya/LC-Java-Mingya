public class ReverseInt {
    // 利用overflow之后会变换数字，所以可以在还原数字一次看看
    // 乘以10之后有没有overflow
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int rem = x % 10;
            int cur = rem + res * 10 ;
            if ( (cur-rem)/10 != res ) {
                return 0;
            }
            res = cur;
            x = x/10;
        }

        return res;
    }
}
