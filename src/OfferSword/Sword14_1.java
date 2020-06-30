package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/29 9:27
 */

/**
 * LeetCode14_1 剪绳子 MEDIUM
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword14_1 {
    /**
     * 动态规划
     * @param n 绳子长度
     * @return 最大乘积
     */
    public int cuttingRopeSolution1(int n) {
        if(n<=3) return n-1;
        int[] dp = new int[n+1];
        dp[2] = 2; dp[3] = 3;
        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }

    /**
     * 数学方法
     * @param n 绳子长度
     * @return 最大乘积
     */
    public int cuttingRopeSolution2(int n) {
        if (n <= 3) return n-1;
        int a = n/3, b = n % 3;
        if (b == 0) return (int)Math.pow(3, a);
        else if (b == 1) return (int)Math.pow(3, a-1) * 4;
        else return (int)Math.pow(3, a) * 2;
    }

}
