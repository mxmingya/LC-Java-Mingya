package OA;

/**
 * Created by mingyama on 9/8/17.
 */
public class Foobar21 {

    public static int[] answer(int h, int[] q) {
        int head = (2 << h) - 1;

        if (q == null || q.length == 0) return new int[0];
        int[] flux_converter = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            if (q[i] < head && q[i] >= 0)
                flux_converter[i] = get_converter(head, q[i], head-1);
        }

        return flux_converter;
    }
    // the general idea is:
    // for every converter, left child = converter - 1 - top/2
    // eg: h = 3, head = 7, head.left = 3, head.right = 6,
    private static int get_converter(int head, int target, int headVal) {
        headVal = headVal/2;
        int right = head - 1;
        int left = head - 1 - (headVal--);


        if (left == target || right == target) return head;

        if (left <= target) {
            return get_converter(right, target, headVal);
        } else {
            return get_converter(left, target, headVal);
        }
    }

    public static void main(String[] args) {
        int[] arr = answer(3, new int[]{7,3,5,1});
        int[] arr2 = answer(5, new int[]{19,14,28});
        for (int i : arr) System.out.print(i);
        System.out.println();
        for (int i : arr2) System.out.print(i);
    }
}
