package LeetcodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode166 分数到小数 MUDIUM
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder decimal = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            decimal.append("-");
        }
        long divided = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        decimal.append(String.valueOf(divided / divisor));
        long remainder = divided % divisor;
        if (remainder == 0) return decimal.toString();
        decimal.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                decimal.insert(map.get(remainder), "(");
                decimal.append(")");
                break;
            }
            map.put(remainder, decimal.length());
            remainder *= 10;
            decimal.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return decimal.toString();
    }
}
