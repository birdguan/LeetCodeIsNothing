package PastExam.other;

import java.util.Scanner;

public class MeituanSolution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt(), d = scanner.nextInt();
        int[] dp = new int[n+1];
        dp[d] = 1;
        for (int i = d+1; i <= n; i++) {
            dp[i] += i / k;
            for (int j = 1; j < i; j++) {
                dp[i] += dp[i-j];
            }
        }
        System.out.println(dp[n]);

    }
}
