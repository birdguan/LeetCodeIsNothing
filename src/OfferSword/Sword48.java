package OfferSword; /**
 * @Author: birdguan
 * @Date: 2020/7/15 17:58
 */

import java.util.HashMap;
import java.util.Map;

/**
 * OfferSword.Sword48 最长不含重复字符的子字符串 MEDIUM
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword48 {
    /**
     * 动态规划 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s 字符串
     * @return 最长不重复字符串长度
     */
    public int lengthOfLongestSubStringSolution1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, dp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            dp = dp < j - i ? dp + 1 : j - i;
            res = Math.max(res, dp);
        }
        return res;
    }

    /**
     * 双指针+哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s 字符串
     * @return 最常不重复子串长度
     */
    public int lengthOfLongestSubStringSolution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j-i);
        }
        return res;
    }
}
