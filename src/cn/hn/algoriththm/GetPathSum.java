package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/6/24.
 */
public class GetPathSum {
    public static int getMinSum(int[][] arr, int x, int y) {
        //位置来到了右下角
        if (x == arr[0].length - 1 && y == arr.length - 1) {
            return arr[x][y];
        }
        //位置处于最右边
        if (x == arr[0].length - 1) {
            return arr[x][y] + getMinSum(arr, x, y + 1);
        }
        //位置处于最下边
        if (y == arr.length - 1) {
            return arr[x][y] + getMinSum(arr, x + 1, y);
        }
        //位置处于中间
        int right = getMinSum(arr, x + 1, y);
        int down = getMinSum(arr, x, y + 1);
        System.out.println("get here");
        return arr[x][y] + Math.min(right, down);

    }

    public static int getMinPathDP(int[][] matrix) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int[][] dp = matrix;
        //dp数组中最后一行上的值等于matrix数组中该位置的值加上dp数组中该位置右边的值
        for (int x = col - 1; x >= 0; x--) {
            dp[row][x] = matrix[row][x] + dp[row][x + 1];
        }
        //dp数组中最后一列的值等于matrix数组中该位置的值加上dp数组中该位置下方的值
        for (int y = row -1 ; y >= 0; y--) {
            dp[y][col] = matrix[y][col] + dp[y + 1][col];
        }
        //dp数组中中间位置的值等于matrix数组中该位置的值加上dp数组中该位置下方和右边的值
        for (int x = col - 1;x >= 0;x --) {
            for (int y = row - 1;y >= 0; y--) {
                dp[x][y] = matrix[x][y] + Math.min(dp[x + 1][y], dp[x][y + 1]);
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(getMinSum(arr, 0, 0));
        System.out.println("in dp is " + getMinPathDP(arr));

    }
}
