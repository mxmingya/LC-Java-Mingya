package TiaoCao;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int p1 = m - 1, p2 = n - 1;
        for (int i = nums1.length-1; i >= 0; i-- ) {
            if (p1 >= 0 && ( p2 < 0 || nums1[p1] > nums2[p2])) {
                nums1[i] = nums1[p1];
                p1--;
            }
            else if (p2 >= 0) {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}
