package SortSearch;

public class BinarySearch {
    public int binarySearch(int[] src, int target) {
        if (src  == null || src.length == 0) {
            return -1;
        }

        int left = 0, right = src.length - 1;
        while (left <= right ) {
            int mid = left + (right - left) / 2;
            if ( src[mid] == target) {
                return mid;
            }
            if (src[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)  {
        int[] arr = {1,4,6,8,11, 17};
        System.out.println(new BinarySearch().binarySearch(arr, 8));
        System.out.println(new BinarySearch().binarySearch(arr, 1));
        System.out.println(new BinarySearch().binarySearch(arr, 10));
    }
}