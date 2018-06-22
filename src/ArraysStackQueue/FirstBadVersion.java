package ArraysStackQueue;

/**
 * Created by mingyama on 10/8/17.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        // binary search
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (!isBadVersion(mid)) {
                left = mid+1;
            } else {//is bad version
                right = mid;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
