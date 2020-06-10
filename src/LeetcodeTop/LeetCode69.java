package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/10 8:53
 */

/**
 * LeetCode69 x的平方根 EASY
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode69 {
    /**
     * 方法一：数学方法
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public int mySqrtSolution1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public int mySqrtSolution2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 方法三：牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrtSolution3(int x) {
        if (x == 0) return 0;
        double c = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
