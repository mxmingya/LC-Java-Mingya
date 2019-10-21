class Solution {
  public void selectionSort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    // selection sort
    int index = 0;
    int global = arr[0];
    for (int i = 0; i < arr.length; i++) {
      for (int j = i;j < arr.length; j++) {
        if (arr[j] < global) {
          index = j;
          global = arr[j];
        }
       }
       int temp = arr[i];
       arr[i] = global;
       arr[index] = temp;
    }
}
