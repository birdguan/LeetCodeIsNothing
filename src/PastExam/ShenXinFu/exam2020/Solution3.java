package PastExam.ShenXinFu.exam2020;


/**
 * 某工厂接到一个订单，需要生产一定数量的零件，该工厂连续n天阐述的零件数构成一个数组nums，货车司机需要分m次将零件
 * 运送到目的地，每次货车司机只能选择运送较早生产的几批零件，如何分批运送m次，使所有运送批次中运载最多的零件数最少。
 */
public class Solution3 {

    public static int min_send (int[] nums, int m) {
        // write code here
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i-1][1] + nums[i-1];
        }
        for (int j = 2; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    int t = Math.max(dp[i][1] - dp[k][1], dp[k][j-1]);
                    if (t < min) min = t;
                }
                dp[i][j] = min;
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 10, 12};
        int min = min_send(nums, 2);
        System.out.println(min);
    }
}
