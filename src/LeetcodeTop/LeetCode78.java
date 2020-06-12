package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/12 10:33
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode78 子集 MEDIUM
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode78 {
    /**
     * 方法一：递归
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsSolution1(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> cur : output) {
                List<Integer> newList = new ArrayList<>(cur);
                newList.add(num);
                newSubsets.add(newList);
            }
            for (List<Integer> cur : newSubsets) {
                output.add(cur);
            }
        }
        return output;
    }

    /**
     * 方法二：回溯
     */
    List<List<Integer>> output = new ArrayList<>();
    // n: 数组长度，k: 当前子集长度
    int n, k;
    private void backtrack(int start, List<Integer> curr, int[] nums) {
        if (curr.size() == k) output.add(new ArrayList<>(curr));
        for (int i = start; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsSolution2(int[] nums) {
        n = nums.length;
        for (k = 0; k <= n; k++) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return output;
    }

    /**
     * 字典排序（二进制排序）
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsSolution3(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
