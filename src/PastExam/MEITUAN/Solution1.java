package PastExam.MEITUAN;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counts = Integer.parseInt(scanner.nextLine());
        for (int idx = 0; idx < counts; idx++) {
            String str = scanner.nextLine();
            char first = str.charAt(0);
            boolean b1 = Character.isUpperCase(first) || Character.isLowerCase(first);
            boolean b2 = true;
            int letterCount = 0, digitCount = 0;
            for (int i = 1; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    letterCount++;
                } else if (Character.isDigit(str.charAt(i))) {
                    digitCount++;
                } else {
                    b2 = false;
                    break;
                }
            }
            if (letterCount < 1 || digitCount < 1) b2 = false;
            String res = b1 && b2 ? "Accept" : "Wrong";
            System.out.println(res);
        }
    }
}
