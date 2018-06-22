package ArraysStackQueue.matrix;

public class rotateImage {
    // 如果顺时针旋转90度，先上下翻转，然后沿对角线翻转
    // 如果逆时针旋转90度，先左右翻转，然后沿对角线翻转
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        // int[][] nMatrix = new int[matrix.length][matrix[0].length];
        int start = 0, end = matrix.length-1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
