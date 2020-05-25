package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/24 22:44
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode17 电话号码的字母组合 MEDIUM
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode17 {
    List<String> result = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    /**
     * dfs
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        dfs("", digits);
        return result;
    }

    private void dfs(String s, String digits) {
        if (digits.length() == 0) result.add(s);
        else {
            String currDigit = digits.substring(0, 1);
            String letters = map.get(currDigit);
            for (int i = 0; i < letters.length(); i++) {
                dfs(s+letters.charAt(i), digits.substring(1));
            }
        }
    }
}
