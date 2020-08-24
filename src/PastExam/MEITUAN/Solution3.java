package PastExam.MEITUAN;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counts = Integer.parseInt(scanner.nextLine());
        int[] weights = new int[counts];
        int[] idxs = new int[counts];
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        for (int i = 0; i < counts; i++) {
            weights[i] = Integer.parseInt(line1[i]);
            idxs[i] = Integer.parseInt(line2[i])-1;
        }
        int[] sumList = new int[counts];
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j <= i; j++) {
                sumList[i] += weights[j];
            }
        }
        for (int idx : idxs) {
            for (int j = idx; j < counts; j++) {
                sumList[j] -= weights[idx];
            }
            int left = sumList[idx];
            int right = sumList[counts-1] - left;
            int max = Math.max(left, right);
            System.out.println(max);
        }

    }
}
