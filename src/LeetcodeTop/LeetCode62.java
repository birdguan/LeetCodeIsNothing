package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/9 17:39
 */

import java.util.Arrays;

/**
 * LeetCode62 不同路径 MEDIUM
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode62 {
    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsSolution1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 动态规划优化一
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(2n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsSolution2(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return cur[n-1];
    }

    /**
     * 动态规划优化二
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsSolution3(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
