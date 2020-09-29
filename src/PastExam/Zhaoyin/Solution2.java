package PastExam.Zhaoyin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    private static List<String> res;
    private static void allOrder(String in, String stack, String out) {
        if (in.equals("") && stack.equals("")) {
            res.add(out);
        }
        if (!in.equals("")) {
            allOrder(in.substring(0, in.length() - 1), stack + in.charAt(in.length()-1), out);
        }
        if (!stack.equals("")) {
            allOrder(in, stack.substring(0, stack.length()-1), out+stack.charAt(stack.length()-1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String in = scanner.nextLine().replace(" ", "");
        res = new ArrayList<>();
        allOrder(in, "", "");
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 下面要做输出格式处理
        int line = 0;
        for (String s : res) {
            line++;
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
                if (i < s.length()-1) System.out.print(" ");
            }
            if (line == 3) {
                System.out.println();
                line = 0;
            } else {
                System.out.print(",");
            }
        }
    }
}
