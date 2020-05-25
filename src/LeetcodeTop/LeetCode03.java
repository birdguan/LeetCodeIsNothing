package LeetcodeTop;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode03 无重复字符的最长子串 MEDIUM
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode03 {
    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = -1, ans = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right+1 < n && !set.contains(s.charAt(right+1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
