package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 10:37
 */

import java.util.Arrays;

/**
 * LeetCode88 合并两个有序数组 EASY
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode88 {
    /**
     * 方法一：合并后排序
     * 时间复杂度：O((m+n)log(m+n))
     * 空间复杂度：O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 方法二：双指针，从前往后
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0, p2 = 0, p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++]);
        }
        if (p1 < m) System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p, n-p2);
    }

    /**
     * 双指针/从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution3(int[] nums1, int m, int [] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while ((p1 >=0) && (p2 >=0)) {
            nums1[p--] = (nums2[p2] > nums1[p1] ? nums2[p2--] : nums1[p1--]);
        }
        // m=0，即nums1为空时
        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }
}
