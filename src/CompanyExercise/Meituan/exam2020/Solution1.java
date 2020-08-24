package CompanyExercise.Meituan.exam2020;


import java.util.Scanner;
import java.util.Stack;

/**
 * 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int n = strs.length;
        if (strs[0].equals("and") || strs[0].equals("or") ||
                strs[n-1].equals("and") || strs[n-1].equals("or")) {
            System.out.println("error");
            return;
        }
        Stack<String> stack = new Stack<>();
        String lastOp = "or";
        stack.push(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (i % 2 == 0 && (strs[i].equals("and") || strs[i].equals("or"))) {
                System.out.println("error");
                return;
            }
            if (i % 2 == 1 && !(strs[i].equals("and") || strs[i].equals("or"))) {
                System.out.println("error");
                return;
            }
            if (i % 2 == 1) lastOp = strs[i];
            if (i % 2 == 0) {
                if (lastOp.equals("and")) {
                    String last = stack.pop();
                    if (last.equals("true") && strs[i].equals("true")) stack.push("true");
                    else stack.push("false");
                } else {
                    stack.push(strs[i]);
                }
            }
        }

        String res = "false";
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if (!tmp.equals("or")) {
                if (!(res.equals("false") && tmp.equals("false"))) {
                    res = "true";
                } else {
                    res = "false";
                }
            }
        }

        System.out.println(Boolean.parseBoolean(res));

    }
}
