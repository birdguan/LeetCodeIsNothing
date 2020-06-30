package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/30 9:02
 */

/**
 * Sword42 连续子数组的最大和 EASY
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword42 {
    /**
     * 动态规划
     * @param nums 数组
     * @return 连续子数组的最大和
     */
    public int maxSubArraySolution1(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 方法二：贪心
     * @param nums 数组
     * @return 连续子数组的最大和
     */
    public int maxSubArraySolution2(int[] nums) {
        int currSum = nums[0];
        int maxSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currSum = currSum > 0 ? currSum + nums[i] : nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
