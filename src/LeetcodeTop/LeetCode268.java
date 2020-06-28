package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 16:34
 */

import java.util.Arrays;

/**
 * LeetCode268 缺失数字 EASY
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode268 {
    private int missingNumber(int[] nums) {
        int len = nums.length;
        int expectedSum = (len * (len + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

}
