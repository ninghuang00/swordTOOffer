package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/7/28.
 */
public class RobotMoveWays {
    /*给你1到N位置,一开始机器人在M位置(1<=M<=N),问机器人走P步之后能到达K位置的方法数量.
    1. 暴力递归
    //N:右边界
    //M:来的位置
    //rest:剩余步数
    //K:目标位置*/
    public int ways(int right, int now, int rest, int target) {
        if (right < 1 || now > right || now < 1 || rest < 0 || target < 1 || target > right) return 0;
        if (rest == 0) {
            return now == target ? 1 : 0;
        }
        if (now == 1) {//在左边界,只能向右走
            return ways(right, now + 1, rest - 1, target);
        } else if (now == right) { //在右边界,只能向左走
            return ways(right, now - 1, rest - 1, target);
        } else {
            return ways(right, now + 1, rest - 1, target) + ways(right, now - 1, rest - 1, target);
        }
    }

    /* 改dp就是一个杨辉三角形
    1. 左边界的值就是右上方的值
    2. 右边界的值就是左上方的值
    3. 普通位置的值就是左上方加右上方*/
    public int betterWays(int right, int now, int rest, int target) throws Exception {
        if (right < 1 || now > right || now < 1 || rest < 0 || target < 1 || target > right) return 0;
        int[][] dp = new int[rest+1][right+1];
        for(int i = 0; i <= right; i++) {
            dp[0][i] = 0;
        }
        dp[0][target] = 1;
        calculate(dp, rest, now);
        printDp(dp);

        return dp[rest][now];
    }

    public void printDp(int[][] dp) {
        for (int i = 0 ; i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public int calculate(int[][] dp, int row, int col) throws Exception{
        if (row >= dp.length || col >= dp[0].length) {
            throw new Exception("out of bound");
        }

        if (row == 0) {
            return dp[row][col];
        }

        if (col == 1) {
            dp[row][col] = calculate(dp, row - 1, col + 1);
            return dp[row][col];
        } else if (col == dp[0].length - 1) {
            dp[row][col] = calculate(dp, row - 1, col - 1);
            return dp[row][col];
        } else {
            dp[row][col] = calculate(dp, row - 1, col + 1) + calculate(dp, row - 1, col - 1);
            return dp[row][col];
        }
    }

    public static void main(String[] args) throws Exception {
        RobotMoveWays robot = new RobotMoveWays();

        int right = 8;
        int now = 4;
        int rest = 6;
        int target = 6;

        System.out.println("ways:" + robot.ways(right,now,rest,target));

        System.out.println("better ways:" + robot.betterWays(right,now,rest,target));
    }


}
