package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/24 9:56
 */

import java.util.*;

/**
 * LeetCode139 单词拆分 MEDIUM
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode139 {
    /**
     * 方法一：暴力，递归回溯 （超出时间限制）
     * @param s 字符串
     * @param wordDict 单词字典
     * @return 是否可拆分
     */
    public boolean wordBreakSolution1(String s, List<String> wordDict){
        return wordBreakHelper(s, wordDict, 0);
    }

    private boolean wordBreakHelper(String s, List<String> wordDict, int start) {
        if (start == s.length()) return true;
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    /* ------------------------------------------------ */


    Boolean[] memo;
    /**
     * 方法二：记忆化回溯
     * @param s 字符串
     * @param wordDict 单词字典
     * @return 是否可拆分
     */
    public boolean wordBreakSolution2(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return wordBreakHelper2(s, wordDict, 0);
    }

    private boolean wordBreakHelper2(String s, List<String> wordDict, int start) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper2(s, wordDict, end)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    /* ---------------------------------------------------- */

    /**
     * bfs
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * @param s 字符串
     * @param wordDict 单词字典
     * @return 是否可拆分
     */
    public boolean wordBreakSolution3(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.offer(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }

    /* ------------------------------------------------------- */

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s 字符串
     * @param wordDict 单词字典
     * @return 是否可拆分
     */
    public boolean wordBreakSolution4(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
