package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/9 20:58
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Sword38 字符串的排列 MEDIUM
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword38 {
    List<String> res = new ArrayList<>();
    char[] chars;

    /**
     * dfs + 回溯
     * @param s 输入字符串
     * @return 字符的所有排列
     */
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {

            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}
