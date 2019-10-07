package SortSearch;

public class SearchA2dMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // 把二维matrix转化为一维的array
        int left = 0, right = matrix.length * matrix[0].length - 1;
        int numOfRow = matrix.length, numOfCol = matrix[0].length;
        while (left  <=  right) {
            int mid = left + ( right - left) / 2;
            int row = mid / numOfRow, col = mid % numOfCol;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}