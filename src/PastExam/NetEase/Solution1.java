package PastExam.NetEase;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] nChild = new int[m+1][2];
        for (int i = 0; i < n; i++) {
            int father = scanner.nextInt();
            String p = scanner.next();
            int child = scanner.nextInt();
            if (p.equals("left")) {
                nChild[father][0] = child;
            } else {
                nChild[father][1] = child;
            }
        }
        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (nChild[i][0] != 0 && nChild[i][1] != 0) {
                int left = nChild[i][0];
                int right = nChild[i][1];
                if (nChild[left][0] == 0 && nChild[left][1] == 0 &&
                        nChild[right][0] == 0 && nChild[right][1] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
