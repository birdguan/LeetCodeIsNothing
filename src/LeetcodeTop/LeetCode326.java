package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 17:37
 */

/**
 * LeetCode326 3的幂 EASY
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        int maxPowerOfThree = (int)Math.pow(3, 19);
        return n > 0 && maxPowerOfThree % n == 0;
    }
}
