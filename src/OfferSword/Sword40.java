package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/29 17:59
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sword40 最小的k个数 EASY
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword40 {
    /**
     * 快速排序
     * 时间复杂度：O(n)
     * @param arr 数组
     * @param k 倒数数
     * @return 结果
     */
    public int[] getLeastNumbersSolution1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        if (pivot == k-1) return Arrays.copyOfRange(nums, 0, k);
        else if (pivot < k - 1) return quickSort(nums, pivot + 1, high, k);
        else return quickSort(nums, low, pivot-1, k);
    }

    private int partition(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low <= high) {
            while (low <= high && nums[high] >= tmp) high--;
            nums[low] = nums[high];
            while (low <= high && nums[low] <= tmp) low++;
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    /* ------------------------------------------------------------- */

    /**
     * 大根堆
     * @param arr 数组
     * @param k 倒数数
     * @return 结果
     */
    public int[] getLeastNumbersSolution2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        Queue<Integer> priorityQ = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (priorityQ.size() < k) {
                priorityQ.offer(num);
            } else if (num < priorityQ.peek()) {
                priorityQ.poll();
                priorityQ.offer(num);
            }
        }

        int[] res = new int[priorityQ.size()];
        int idx = 0;
        for (int num : priorityQ) res[idx++] = num;
        return res;
    }
}
