package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/24 21:37
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode15 三数之和 MEDIUM
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; //如果当前数字大于0，则三数之和一定大于0，所以循环结束
            if (i > 0 && nums[i] == nums[i-1]) continue; //去重
            int left = i+1, right = len-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++; //去重
                    while (left < right && nums[right] == nums[right-1]) right--; //去重
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}
