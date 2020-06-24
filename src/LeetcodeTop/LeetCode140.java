package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/24 11:21
 */

import java.util.*;

/**
 * LeetCode140 单词拆分 HARD
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode140 {
    /**
     * 记忆化回溯
     * 时间复杂度：O(n^3)
     * @param s 字符串
     * @param wordDict 单词表
     * @return 所有可能的拆分结果
     */
    public List<String> wordBreakSolution1(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    Map<Integer, List<String>> map = new HashMap<>();
    private List<String> wordBreakHelper(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) return map.get(start);
        List<String> res = new ArrayList<>();
        if (start == s.length()) res.add("");
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreakHelper(s, wordDict, end);
                for (String str : list) {
                    res.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    /* --------------------------------------------------------------- */

    /**
     * 动态规划
     * @param s 字符串
     * @param wordDict 单词表
     * @return 所有可能的拆分结果
     */
    public List<String> wordBreakSolution2(String s, Set<String> wordDict) {
        List<String>[] dp = new ArrayList[s.length()+1];
        List<String> init = new ArrayList<>();
        init.add("");
        dp[0] = init;
        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String str : dp[j]) {
                        list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}
