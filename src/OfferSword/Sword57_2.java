package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/30 16:02
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Sword57_2 和为s的连续正数序列 EASY
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword57_2 {
    /**
     * 滑动窗口
     * @param target 和
     * @return 连续正数序列结果
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= target/2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int k = left; k < right; k++) {
                    arr[k-left] = k;
                }
                res.add(arr);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
