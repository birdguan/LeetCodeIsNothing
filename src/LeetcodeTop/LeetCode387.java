package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 19:51
 */

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode387 字符串中的第一个唯一字符 EASY
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
