package PastExam.WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    private static int[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < q; i++) {
            int query = scanner.nextInt();
            int LargerTarget = binarySearchLargerThan(query);
            int SmallerTarget = binarySearchSmallerThan(query);
            int SmallerAbs = Math.abs(query - SmallerTarget);
            int LargerAbs = Math.abs(query - LargerTarget);
            int res = SmallerAbs <= LargerAbs ? SmallerTarget : LargerTarget;
            System.out.println(res);
        }
    }

    private static int binarySearchLargerThan(int target) {
        if (target > nums[nums.length-1]) return nums[nums.length-1];
        if (target < nums[0]) return nums[0];
        int ans = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (target <= midValue) {
                right = mid - 1;
                ans = Math.min(ans, nums[mid]);
            } else left = mid + 1;
        }
        return ans;
    }

    private static int binarySearchSmallerThan(int target) {
        if (target > nums[nums.length-1]) return nums[nums.length-1];
        if (target < nums[0]) return nums[0];
        int ans = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (target >= midValue) {
                left = mid + 1;
                ans = Math.max(ans, nums[mid]);
            } else right = mid - 1;
        }
        return ans;
    }
}

/*
5 5
1 2 3 4 5
3
0
7
2
5
 */