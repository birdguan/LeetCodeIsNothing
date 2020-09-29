package PastExam.JD;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb;
        StringBuilder res = new StringBuilder();
        String[] strs = scanner.nextLine().split(" ");
        for (String str: strs) {
//            String str = scanner.next();
            sb = new StringBuilder();
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                for (int i = 0; i < str.length(); i++) {
                    if (i == str.length() - 1) {
                        if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            sb.append(str.charAt(i));
                        }
                    } else {
                        sb.append(str.charAt(i));
                    }
                }
            }
            try {
                int num = Integer.parseInt(sb.toString());
                if (num >= 1000 && num <= 3999) res.append(num).append(" ");
            } catch (Exception e) {

            }
        }
        System.out.println(res.toString().trim());
    }


}
