package PastExam.WeBank;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
        x = x % 4; y = y % 2; z = z % 4;
        int n = scanner.nextInt(), m = scanner.nextInt();
        int query = scanner.nextInt();
        int middleV = (n+1) / 2, middleH = (m+1) / 2;
        for (int q = 0; q < query; q++) {
            int[] pos = new int[2];
            pos[0] = scanner.nextInt() - middleV;
            pos[1] = scanner.nextInt() - middleH;
            for(int i = 0; i < x; i++) {
                pos = rotateCircle(pos);
            }
            for (int i = 0; i < y; i++) {
                pos = flip(pos);
            }
            for (int i = 0; i < z; i++) {
                pos = rotateAntiCircle(pos);
            }
            int posV = pos[0] + middleV, posH = pos[1] + middleH;
            System.out.println(posV + 1 + " " + posH);
        }

    }

    private static int[] rotateCircle(int[] pos) {
        int[] newPos = new int[2];
        newPos[0] = pos[1];
        newPos[1] = -pos[0];
        return newPos;
    }

    private static int[] rotateAntiCircle(int[] pos) {
        int[] newPos = new int[2];
        newPos[0] = -pos[1];
        newPos[1] = pos[0];
        return newPos;
    }

    private static int[] flip(int[] pos) {
        int[] newPos = new int[2];
        newPos[0] = pos[0];
        newPos[1] = -pos[1];
        return newPos;
    }
}

/*
1 1 1
4 5
3
1 1
3 4
2 5
 */
