package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 8:57
 */

import java.util.*;

/**
 * LeetCode46 全排列 MEDIUM
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode46 {
    /**
     * DFS（回溯）
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        for (int num :nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first+1);
            Collections.swap(output, first, i);
        }
    }
}
