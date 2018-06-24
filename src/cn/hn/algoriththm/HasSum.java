package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/6/24.
 */
public class HasSum {
    public static boolean hasSUm(int[] arr, int index, int aim, int sum) {
        if (index == arr.length) {
            return sum == aim;
        }
        //选择加上当前值,或者不加上当前值
        return hasSUm(arr, index + 1, aim, sum + arr[index]) || hasSUm(arr, index + 1, aim, sum);
    }

    public static boolean hasSumDP(int[] arr, int aim) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (aim > sum) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < sum; i++) {
            dp[n][i] = false;
        }
        dp[n][aim] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = sum; j >= 0; j--) {
                if (j + arr[i] <= sum) {
                    dp[i][j] = dp[i + 1][j + arr[i]] || dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 4};
        int aim = 6;
        System.out.println(hasSUm(arr, 0, aim, 0));
        System.out.println(hasSumDP(arr, aim));
    }


}
