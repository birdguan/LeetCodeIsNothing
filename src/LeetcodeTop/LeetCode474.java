package LeetcodeTop;

/**
 * LeetCode474 一和零 MEDIUM
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 *
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 *
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int[] counts = countZerosOnes(s);
            for (int zeroes = m; zeroes >= counts[0]; zeroes--) {
                for (int ones = n; ones >= counts[1]; ones--) {
                    dp[zeroes][ones] = Math.max(dp[zeroes][ones],
                    1 + dp[zeroes - counts[0]][ones - counts[1]]);
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print(dp[i][j] + " ") ;
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[m][n];
    }

    private int[] countZerosOnes(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }

    public static void main(String[] args) {
        LeetCode474 leetCode474 = new LeetCode474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        leetCode474.findMaxForm(strs, 5, 3);
    }
}
