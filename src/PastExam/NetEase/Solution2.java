package PastExam.NetEase;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        int res = 0, status = 0;
        int[] pos = new int[1 << 6];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a':
                    status ^= (1 << 0);
                    break;
                case 'b':
                    status ^= (1 << 1);
                    break;
                case 'c':
                    status ^= (1 << 2);
                    break;
                case 'x':
                    status ^= (1 << 3);
                    break;
                case 'y':
                    status ^= (1 << 4);
                    break;
                case 'z':
                    status ^= (1 << 5);
                    break;
            }
            if (pos[status] >= 0) res = Math.max(res, i+1- pos[status]);
            else pos[status] = i+1;
        }
        System.out.println(res);
    }
}
