package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 12:04
 */

/**
 * LeetCode204 计数质数 EASY
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class LeetCode204 {
    /**
     * 排除法
     * @param n 非负整数
     * @return 质数数量
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = n / 2;
        boolean[] isPrimes = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            // 不是质数 continue;
            if (isPrimes[i]) continue;
            for (int j = i*i; j < n; j += 2*i) {
                if (!isPrimes[j]) {
                    count--;
                    isPrimes[j] = true;
                }
            }
        }
        return count;
    }
}
