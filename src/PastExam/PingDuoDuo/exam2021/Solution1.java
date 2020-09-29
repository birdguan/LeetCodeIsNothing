package PastExam.PingDuoDuo.exam2021;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] res = new int[n][n];
        for (int i = 0; i < n/2 - 1; i++) {
            for (int j = n - n / 2; j < n - 1 - i; j++) {
                res[i][j] = 1;
            }
        }

        for (int i = 0; i < n/2 - 1; i++) {
            for (int j = i+1; j < n/2; j++) {
                res[i][j] = 2;
            }
        }

        for (int i = 1; i < n/2; i++) {
            for (int j = 0; j < i; j++) {
                res[i][j] = 3;
            }
        }

        for (int i = n - n/2; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                res[i][j] = 4;
            }
        }

        for (int i = n - n / 2 + 1; i <n; i++) {
            for (int j = n - i; j < n / 2; j++) {
                res[i][j] = 5;
            }
        }

        for (int i = n - n / 2; i < n; i++) {
            for (int j = n - n/2; j < i; j++) {
                res[i][j] = 6;
            }
        }

        for (int i = n - n / 2; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                res[i][j] = 7;
            }
        }

        for (int i = 1; i < n/2; i++) {
            for (int j = n - i; j < n; j++) {
                res[i][j] = 8;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                if (j != n-1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
