package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 8:51
 */

/**
 * LeetCode44 通配符匹配 HARD
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * 通过次数30,320提交次数109,341
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode44 {
    /**
     * 动态规划
     * 时间复杂度：O(SP)
     * 空间复杂度：O(SP)
     * @param s 输入字符
     * @param p 匹配字符
     * @return 是否匹配
     */
    public boolean isMatchSolution1(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (p.equals(s) || p.equals("*")) return true;
        if (p.isEmpty() || s.isEmpty()) return false;
        // dp[m][n]表示isMatch(s.substring(0, n), p.substring(0, m))
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        // DP流程
        for (int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // 当前字符是‘*’
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;
                while ((sIdx < sLen + 1) && (!dp[pIdx - 1][sIdx - 1])) sIdx++;
                dp[pIdx][sIdx - 1] = dp[pIdx - 1][sIdx - 1];
                while (sIdx < sLen + 1) dp[pIdx][sIdx++] = true;
            }
            // 当前字符是'?'
            else if (p.charAt(pIdx - 1) == '?'){
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx - 1];
                }
            }
            // 当前字符不是‘*’或者'?'
            else {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx - 1] && (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }
        return dp[pLen][sLen];
    }

    public boolean isMatchSolution2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i-1) == '*') dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) =='*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    /**
     * 方法二：回溯
     * 时间复杂度：O(SlogP)
     * 控件复杂度：O(1)
     * @param s 输入字符
     * @param p 匹配字符
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;
        while (sIdx < sLen) {
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            }
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            }
            else if (starIdx == -1) {
                return false;
            }
            else {
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }
        for (int i = pIdx; i < pLen; i++) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }
}
