package PastExam.Tencent.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] sortedNum = Arrays.copyOfRange(nums, 0, n);
        StringBuilder res = new StringBuilder();
        Arrays.sort(sortedNum);
        int right = sortedNum[n/2];
        int left = sortedNum[n/2 - 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] < right) System.out.println(right);
            else System.out.println(left);
        }
    }
}
