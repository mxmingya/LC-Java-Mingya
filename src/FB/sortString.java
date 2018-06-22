package FB;

/**
 * Created by mingyama on 10/31/17.
 */
public class sortString {

    public void sortString(char[] chars, int[] index) {
        if (chars == null || index == null ) return;
        for (int i = 0; i < chars.length; i++) {
            while (index[i] != i) {
                char temp = chars[i];
                chars[i] = chars[index[i]];
                chars[index[i]] = temp;
                swap(index, i, index[i]);
            }
        }
    }

    private void swap(int[] index, int i, int j) {
        int temp = index[i];
        index[i] = index[j];
        index[j] = temp;
    }

    public static void main(String[] a) {
        int[] index = new int[] {3,2,4,1,5,0};
        char[] chars = new char[] {'D','C','E','B','F','A'};
        new sortString().sortString(chars, index);
        for (int i : chars) {
            System.out.printf("%c, ", i);
        }
    }
}
