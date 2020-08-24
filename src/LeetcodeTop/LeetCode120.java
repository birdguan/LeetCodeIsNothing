package LeetcodeTop;


import java.util.List;

/**
 * LeetCode120 三角形最小路径和 MEDIUM
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode120 {
    /**
     * 动态规划
     * @param triangle  三角形数组
     * @return          三角形最小路径和
     */
    public int minimumTriangle(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int[][] dp = new int[depth][depth];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < depth; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int res = dp[depth-1][0];
        for (int i = 1; i < depth; i++) {
            res = Math.min(res, dp[depth-1][i]);
        }
        return res;
    }

    /**
     * 空间优化的动态规划
     * @param triangle      三角形数组
     * @return              三角形最小路径和
     */
    public int minimumTriangleSolution2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + triangle.get(0).get(0);
            for (int j = i-1; j > 0; j--) {
                dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
