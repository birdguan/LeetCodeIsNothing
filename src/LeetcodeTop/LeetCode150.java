package LeetcodeTop;

import java.util.Stack;

/**
 * LeetCode 150 逆波兰表达式（后缀表达式）求值 MEDIUM
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0;
        for (String val : tokens) {
            if ("+-*/".contains(val)) {
                a = stack.pop();
                b = stack.pop();
            }
            switch (val) {
                case "+": stack.push(b + a); break;
                case "-": stack.push(b - a); break;
                case "*": stack.push(b * a); break;
                case "/": stack.push(b / a); break;
                default: stack.push(new Integer(val));
            }
        }
        return stack.pop();
    }
}
