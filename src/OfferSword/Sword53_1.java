package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/30 10:32
 */

/**
 * Sword53_1 在排序数组中查找数字（1） EASY
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword53_1 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] <= target) low = middle + 1;
            else high = middle - 1;
        }
        return low;
    }
}
