package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/1 9:17
 */

/**
 * LeetCode41 缺失的第一个正数 HARD
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode41 {
    /**
     * 算法步骤：
     * 1.检查1是否存在于数组中。如果没有，则已完成，1即为答案。
     * 2.如果nums = [1]，答案即为2.
     * 3.将负数，零，大于n的数替换为1。
     * 4.遍历数组。当读到数字a时，替换第a个元素的符号。注意重复元素：只能改变一次符号。由于没有下标n，使用下标0的元素保存是否存在数字n。
     * 5.再次遍历数组。返回第一个元素的下标。
     * 6。如果nums[0]>0，则返回n
     * 7。如果之前的步骤中没有发现nums中有正数的元素，则返回n+1
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int contains = 0;
        for (int num : nums) {
            if (num == 1) {
                contains++;
                break;
            }
        }
        // 数组中如果没有1，那么1就是缺失的第一个正数
        if (contains == 0) return 1;
        // nums = [1]，那么2就是缺失的第一个正数
        if (n == 1) return 2;
        // 用1替换负数、0、大于n的数
        // 在转换后，nums只会包含正数
        for (int i = 0; i < n; i++) {
            if (nums[i] <=0 || nums[i] > n) nums[i] = 1;
        }
        // 使用索引和数字符号作为检查器
        // 例如，如果nums[1]是负数表示在数组中出现了数字1
        // 如果nums[2]是正数，表示数字2没有出现
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) nums[0] = -Math.abs(nums[0]);
            else nums[a] = -Math.abs(nums[a]);
        }
        // 现在第一个正数的下标就是第一个缺失的数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return n;
        return n+1;
    }

}
