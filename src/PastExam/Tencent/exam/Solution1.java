package PastExam.Tencent.exam;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }
        int index1 = 0, index2 = 0;
        StringBuilder res = new StringBuilder();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index1++;
            } else {
                res.append(nums1[index1]).append(" ");
                index1++;
                index2++;
            }
        }
        System.out.println(res.toString().trim());
    }

}
