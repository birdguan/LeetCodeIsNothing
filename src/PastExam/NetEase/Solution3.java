package PastExam.NetEase;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] link = new int[n];
        for (int i = 1; i < n; i++) {
            link[i] = scanner.nextInt();
        }
        int deepest = 0;
        for (int i = 1; i < n; i++) {
            int x = i;
            int d = 0;
            while (x != 0) {
                x = link[x];
                d++;
            }
            if (d > deepest) {
                deepest = d;
            }
        }
        if (deepest >= k) {
            System.out.println(k+1);
        } else {
            System.out.println(Math.min(n, 1+deepest+(k-deepest)/2));
        }
    }
}
