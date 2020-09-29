package PastExam.Baidu.exam2021;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n5 = 0;
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            if (c == 5) {
                n5++;
            }
        }
        int n0 = n - n5;
        if (n5 >= 9 && n0 > 0) {
            for (int i = 0; i < n5 - n5 % 9; i++) {
                System.out.print(5);
            }
            for (int i = 0; i < n0; i++) {
                System.out.print(0);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}
