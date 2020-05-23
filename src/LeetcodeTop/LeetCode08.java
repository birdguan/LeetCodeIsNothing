package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/23 19:52
 */
import java.util.HashMap;
import java.util.Map;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode08 {
    /**
     * 有限状态机
     *                          *    状态机表格     *
     * -------------------------------------------------------------------------
     *            |       ' '     |       +/-      |    number     |     other
     * —————————————————————————————————————————————————————————————————————————
     * start      |     start     |      end       |   in_number   |     end
     * _________________________________________________________________________
     * signed     |     end       |      end       |   in_number   |     end
     * _________________________________________________________________________
     * in_number  |     end       |      end       |   in_number   |     end
     * _________________________________________________________________________
     * end        |     end       |      end       |     end       |     end
     * _________________________________________________________________________
     */
    class Automaton {
        final String START = "start";
        final String SIGNED = "signed";
        final String IN_NUM = "in_number";
        final String END = "end";
        String state = START;
        Map<String, String[]> map;
        public int sign = 1;
        public long ans = 0;
        public Automaton() {
            map = new HashMap<>();
            map.put(START, new String[] {START, SIGNED, IN_NUM, END});
            map.put(SIGNED, new String[] {END, END, IN_NUM, END});
            map.put(IN_NUM, new String[] {END, END, IN_NUM, END});
            map.put(END, new String[] {END, END, END, END});
        }

        public int get_col(char c) {
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (c >= '0' && c <= '9') return 2;
            return 3;
        }

        public void get(char c) {
            state = map.get(state)[get_col(c)];
            if (state.equals(IN_NUM)) {
                ans = ans * 10 + c - '0';
                if (sign == 1) {
                    ans = Math.min(ans, Integer.MAX_VALUE);
                } else {
                    ans = Math.min(ans, -(long)Integer.MIN_VALUE);
                }
            } else if (state.equals(SIGNED)) {
                sign = c == '+' ? 1 : -1;
            }
        }
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            automaton.get(ch);
        }
        return automaton.sign * ((int) automaton.ans);
    }
}

