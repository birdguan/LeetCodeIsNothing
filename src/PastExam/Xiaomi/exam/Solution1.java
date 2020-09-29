package PastExam.Xiaomi.exam;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            int strLen = str.length();
            if (strLen < 8 || strLen > 120) {
                System.out.println("1");
                continue;
            }
            int[] counts = new int[4];
            for (char ch : str.toCharArray()) {
                if (ch >= '0' && ch <= '9') counts[0]++;
                else if (ch >= 'A' && ch <= 'Z') counts[2]++;
                else if (ch >= 'a' && ch <= 'z') counts[3]++;
                else counts[1]++;
            }
            if (counts[0] == 0 || counts[1] == 0 || counts[2] == 0 || counts[3] == 0) {
                System.out.println("2");
            } else {
                System.out.println("0");
            }
        }
    }
}
