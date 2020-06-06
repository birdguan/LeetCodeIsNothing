package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 20:36
 */

/**
 * LeetCode50 Pow(x,n) MEDIUM
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode50 {
    /**
     * 快速幂+递归
     * 时间复杂度：O(logN)
     * 控件复杂度：O(logN)
     * @param x
     * @param n
     * @return
     */
    private double quickPowSolution1(double x, int n) {
        if (n == 0) return 1.0;
        double y = quickPowSolution1(x, n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double myPowSolution1(double x, int n) {
        return n >= 0 ? quickPowSolution1(x, n) : 1.0 / quickPowSolution1(x, -n);
    }

    /**
     * 快速幂+迭代
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param x
     * @param n
     * @return
     */
    private double quickPowSolution2(double x, int n) {
        double ans = 1.0;
        double xContribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xContribute;
            }
            xContribute *= xContribute;
            n /= 2;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        return n >= 0 ? quickPowSolution2(x, n) : 1.0 / quickPowSolution2(x, -n);
    }


}
