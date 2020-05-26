package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/26 14:18
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode22 括号生成 MEDIUM
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode22 {
    /**
     * 方法一：dfs
     * @param n
     * @return
     */
    public List<String> generateParenthesisSolution1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(n, n, "", res);
        return res;
    }

    private void dfs(int left, int right, String currStr, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(currStr);
            return;
        }
        // 剪枝
        if (left > right) return;
        if (left > 0) dfs(left-1,right, currStr+"(", res);
        if (right > 0) dfs(left, right-1, currStr+")", res);
    }

    /**
     * 方法二：动态规划
     * 第一步
     * 定义状态dp[i]：使用i对括号能够生成的组合
     * 第二步
     * 状态转移方程：dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * 即 dp[i] = "(" + dp[j] + ")" + dp[i-j-1], j=0,1,...,i-1
     * 第三步
     * 思考初始状态和输出：
     * 初始状态dp[0],输出dp[n]
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisSolution2(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-j-1);
                for (String s1: str1) {
                    for (String s2: str2) {
                        curr.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }
}
