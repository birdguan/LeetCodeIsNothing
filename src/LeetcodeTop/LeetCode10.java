package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/23 19:55
 */


/**
 * LeetCode10 正则表达式匹配 HARD
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode10 {
    boolean[][] memo;
    /**
     * 动态规划，自顶向下的方法
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchSolution1(String text, String pattern) {
        memo = new boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            // 后面有*, text匹配pattern*后面的或者text后一位匹配当前pattern字符
            if (j+1 < pattern.length() && pattern.charAt(j+1) == '*') {
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans;
        return ans;
    }


    /********************************************/

    /**
     * 动态规划，自底向上的方法
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchSolution2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length()-1; j >=0; j--) {
                boolean firstMatch = i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
                if (j+1 < pattern.length() && pattern.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];

    }
}
