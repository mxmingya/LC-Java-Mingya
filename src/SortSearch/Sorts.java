package SortSearch;
import java.util.*;
/**
 * Created by mingyama on 10/16/17.
 */
public class Sorts {

    public void selectionSort(int[] arr) {
        int minPointer = 0;

        for (;minPointer < arr.length; minPointer++) {
            int min = arr[minPointer];
            for (int i = minPointer; i < arr.length; i++) {
                if (arr[i] < min) {

                }
            }
        }
    }

    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : list) {
            System.out.printf("%d, ", i);
        }
        System.out.println(list.size());
    }
}
