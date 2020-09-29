package PastExam.other;

import java.util.Scanner;

public class MeituanSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
        int[] products = new int[n];
        for (int i = 0; i < n; i++) {
            products[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i <= n-m; i++) {
            boolean valid = true;
            for (int j = i; j < i+m; j++) {
                if (products[j] < k) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res++;
            }
        }
        System.out.println(res);
    }
}
