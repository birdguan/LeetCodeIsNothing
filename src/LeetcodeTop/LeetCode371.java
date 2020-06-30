package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 19:30
 */

/**
 * LeetCode371 两整数之和 EASY
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode371 {
    /**
     * 位操作
     * @param a 加数1
     * @param b 加数2
     * @return 两整数之和
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
