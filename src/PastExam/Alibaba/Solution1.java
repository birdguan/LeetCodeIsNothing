package PastExam.Alibaba;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
        int c = scanner.nextInt(), d = scanner.nextInt();
        n = n*n;
        int resA = C_mn(n, a) % 998244353;
        int resB = C_mn(n-a, b) % 998244353;
        int resC = C_mn(n-a-b, c) % 998244353;
        int resD = C_mn(n-a-b-c, d) % 998244353;
        int res = resA*resB*resC*resD % 998244353;
        System.out.println(res);
//        System.out.println(C_mn(100, 50));
    }

    private static int C_mn(int n, int m) {
//        int son = 1;
//        int mother = 1;
//        for (int i = 0; i < m; i++) {
//            son = son * n;
//            n--;
//        }
//        for (; m > 0; m--) {
//            mother = mother * m;
//        }
//        return son/mother;
        int son = 1;
        int mother = 1;
        m = Math.min(m, (n - m));
        for (int i = m; i > 0; i--) {
            son *= n;
            mother *= i;
            n--;
        }
        return son/mother;
    }
}
