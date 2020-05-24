package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/24 20:23
 */

import java.util.Map;

/**
 * LeetCode14 最长公共前缀 EASY
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode14 {
    /**
     * 方法一：水平扫描法
     * 时间复杂度：O(S)，S为所有字符串中字符数量的总和
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefixSolution1 (String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * 二分查找法
     * @param strs
     * @return
     */
    public String longestCommonPrefixSolution2 (String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str: strs)
            minLen = Math.min(minLen, str.length());
        int low = 1, high = minLen;
        while (low <= high) {
            int middle = (low + high)/2;
            if (isCommonPrefix(strs, middle)) low = middle+1;
            else high = middle-1;
        }
        return strs[0].substring(0, (low+high)/2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1))
                return false;
        }
        return true;
    }
}
