package LeetcodeTop;


/**
 * LeetCode494 目标和 MEDIUM
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i-1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i-1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i-1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public int result = 0;
    public int findTargetSumWaysBacktrack(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, 0, target);
        return result;
    }

    void backtrack(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) result++;
            return;
        }
        rest += nums[i];
        backtrack(nums, i+1, rest);
        rest -= nums[i];

        rest -= nums[i];
        backtrack(nums, i+1, rest);
        rest += nums[i];
    }

    public int findTargetSumWaysDpSolution(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum < target || (sum + target) % 2 == 1) return 0;
        return subsets(nums, (sum + target) / 2);
    }

    int subsets(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target+1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
