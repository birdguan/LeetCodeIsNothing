package PastExam.YuanFuDao.exam0822;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        StringBuilder res = new StringBuilder();
        int layer = 0;
        while (Math.pow(2, layer) <= n) {
            res.append(nums[(int)Math.pow(2, layer)-1]).append(" ");
            layer++;
        }
        int index = (int) Math.pow(2, layer-1);
        while (++index <= n) {
            res.append(nums[index-1]).append(" ");
        }
        index = (int)Math.pow(2, layer-2);
        while (++index <= (int)Math.pow(2, layer -1) - 1) {
            res.append(nums[index-1]).append(" ");
        }
        index = ((int)Math.pow(2, layer-1) - 1) / 2;
        while (index >= 3) {
            res.append(nums[index-1]).append(" ");
            index /= 2;
        }
        System.out.println(res.toString().trim());

    }
}
