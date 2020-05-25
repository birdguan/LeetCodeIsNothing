package LeetcodeTop;

import java.util.Map;

/**
 * LeetCode04 寻找两个正序数组的中位数 HARD
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode04 {
    /**
     * 二分法对数组进行切分
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); //保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]) {
                iMin = i+1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) {
                iMax = i-1;
            } else {
                int maxLeft = 0;
                if (i == 0) maxLeft = B[j-1];
                else if (j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);
                if ((m+n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[j];
                else minRight = Math.min(A[i], B[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
