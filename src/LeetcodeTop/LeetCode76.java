package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/11 13:08
 */

import DesignPattern.BehavioralPatterns.StrategyPattern.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode76 最小覆盖子串 HARD
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode76 {
    /**
     * 滑动窗口
     */
    Map<Character, Integer> ori = new HashMap<>(); // t中所有的字符以及它们的个数
    Map<Character, Integer> cnt = new HashMap<>(); // 窗口中的字符以及它们的个数

    public String minWindow(String s, String t) {
        int tLen = s.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori .put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            r++;
            // 如果窗口中存在t中的字符，则将cnt哈希表中该字符计数加一
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            //
            while (check() && l <= r) {
                // 结果窗口更新为更小的窗口
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 窗口左边界向右收缩
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Character key : ori.keySet()) {
           if (cnt.getOrDefault(key, 0) < ori.get(key)) {
               return false;
           }
        }
        return true;
    }
}
