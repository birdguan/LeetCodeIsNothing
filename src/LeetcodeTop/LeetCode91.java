package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 11:21
 */

/**
 * LeetCode91 解码方法 MEDIUM
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode91 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != '0') dp[i] = dp[i-1];
            int num = 10 * (chars[i-1] - '0') + (chars[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) dp[i] += 1;
                else dp[i] += dp[i-2];
            }
        }
        return dp[n-1];
    }

}
