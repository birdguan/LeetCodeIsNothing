package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/4 21:36
 */

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Sword20 表示数值的字符串 EASY
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword20 {
    /**
     * 状态机
     * 0 开始的空格
     * 1 幂符号前的正负号
     * 2 小数点前的数字
     * 3 小数点、小数点后的数字
     * 4 当小数点前为空格时，小数点、小数点后的数字
     * 5 幂符号
     * 6 幂符号后的正负号
     * 7 幂符号后的数字
     * 8 结尾的空格
     * @param s 字符串
     * @return 输入的字符串是否可以表示数值
     */
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 4);}},
                new HashMap<Character, Integer>(){{put('d', 2); put('.', 4);}},
                new HashMap<Character, Integer>(){{put('d', 2); put('.', 3); put('e', 5); put(' ', 8);}},
                new HashMap<Character, Integer>(){{put('d', 3); put('e', 5); put(' ', 8);}},
                new HashMap<Character, Integer>(){{put('d', 3);}},
                new HashMap<Character, Integer>(){{put('s', 6); put('d', 7);}},
                new HashMap<Character, Integer>(){{put('d', 7);}},
                new HashMap<Character, Integer>(){{put('d', 7); put(' ', 8);}},
                new HashMap<Character, Integer>(){{put(' ', 8);}}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == '.' || c == 'e' || c == 'E' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}
