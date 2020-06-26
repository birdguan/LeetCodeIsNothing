package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/23 17:12
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode131 分割回文串 MEDIUM
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode131 {
    /**
     * 回溯
     * @param s 字符串
     * @return 所有可能的分割方案
     */
    public List<List<String>> partitionSolution1(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int len = s.length();
        Stack<String> path = new Stack<>();
        backtracking(s, 0, len, path, res);
        return res;
    }

    private void backtracking(String s, int start, int len, Stack<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) continue;
            path.push(s.substring(start, i+1));
            backtracking(s, i+1, len, path, res);
            path.pop();
        }
    }

    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


    /* ----------------------------------------------- */

    /**
     * 回溯 + 动态规划
     * @param s 输入字符串
     * @return 所有可能的分割方案
     */
    public List<List<String>> partitionSolution2(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2) || dp[left+1][right-1]) {
                    dp[left][right] = true;
                }
            }
        }
        Stack<String> path = new Stack<>();
        backtrackingSolution2(s, 0, len, dp, path, res);
        return res;

    }

    private void backtrackingSolution2(String s,
                                       int start,
                                       int len,
                                       boolean[][] dp,
                                       Stack<String> path,
                                       List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!dp[start][i]) continue;
            path.push(s.substring(start, i+1));
            backtrackingSolution2(s, i+1, len, dp, path, res);
            path.pop();
        }

    }
}
