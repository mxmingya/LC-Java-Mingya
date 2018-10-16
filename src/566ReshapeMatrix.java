    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) return nums;
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] ret = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                int cur = i * n + j ;
                int row = cur / c, col = cur % c;
                int pre = nums[i][j];
                // System.out.printf("cur:%d, row:%d, col:%d, pre:%d\n", cur, row, col, pre);
                ret[row][col] = pre;
            }
        }
        return ret;
    }