package PastExam.WeBank;

import java.util.Scanner;

public class Solution3 {

    private static int max = 100001;
    private static int[] sum = new int[max << 2], dpl = new int[max], dpr = new int[max], val = new int[max];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int lim = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            lim  = Math.max(lim, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            dpl[i] = qu(1, lim, 1, val[i], 1);
            update(1, lim, val[i], 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            dpr[i] = qu(1, lim, val[i], lim, 1);
            update(1, lim, val[i], 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dpl[i] * dpr[i] + (i - dpl[i]) * (n - i - 1  - dpr[i]);
        }
        System.out.println(res);
//        int[][] dp = new int[n][3];
//        int res = 0;
//        for (int i = 0; i < n; i++) dp[i][0] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] <= nums[i]) {
//                    dp[i][1] += dp[j][0];
//                    dp[i][2] += dp[j][1];
//                }
//            }
//            res += dp[i][2];
//        }
        System.out.println(res);
    }

    private static void update(int l, int r, int p, int k) {
        int ls, rs, mid;
        if (l == r) {
            sum[k] = l;
            return;
        }
        ls = k << 1;
        rs = ls | 1;
        mid = (l + r) >> 1;
        if (p <= mid) update(l, mid, p, ls);
        else update(mid + l, r, p, rs);
        sum[k] = sum[ls] + sum[rs];

    }

    private static int qu(int L, int R, int l, int r, int k) {
        int ls, rs, mid;
        if (l == L && r == R) return sum[k];
        ls = k << 1;
        rs = ls | 1;
        mid = L + (R - L) / 2;
        if (l > mid) return qu(mid+1, R, l, r, rs);
        else if (r <= mid) return qu(L, mid, l, r, ls);
        else return qu(L, mid, l, mid, ls) + qu(mid + 1, R, mid+1, r, rs);
    }

}


/*
6
2 3 5 4 3 3
 */
