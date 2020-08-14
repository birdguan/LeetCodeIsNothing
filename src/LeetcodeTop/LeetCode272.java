package LeetcodeTop;


import java.util.Stack;

/**
 * LeetCode227 基本计算器2 MEDIUM
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode272 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;
            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + arr[i] - '0';
                }
                i--;
                if (lastOp == '+') stack.push(tempNum);
                else if (lastOp == '-') stack.push(-tempNum);
                else stack.push(res(lastOp, stack.pop(), tempNum));
            } else {
                lastOp = arr[i];
            }
        }
        int res = 0;
        for (int num : stack) res += num;
        return res;
    }

    private int res(char op, int a, int b) {
        if (op == '*') return a*b;
        else if (op == '/') return a / b;
        else if (op == '+') return a + b;
        else return a - b;
    }
}
