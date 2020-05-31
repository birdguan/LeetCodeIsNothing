package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/31 17:11
 */

/**
 * LeetCode33 搜索旋转排序数组 MEDIUM
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode33 {
    /**
     * 数组转换后二分
     * @param nums
     * @param target
     * @return
     */
    public int searchSolution1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // target >= nums[0], 说明目标在左半段
            if (target >= nums[0]) {
                // 当目标值在左半段而mid在右半段时，nums[mid]改为Integer.MAX_VALUE
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 当目标值在右半段而mid在左半段时，nums[mid]改为Integer.MIN_VALUE
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * 先根据nums[mid]与nums[low]的关系判断mid是在左段还是右段，
     * 接下来再判断target是在mid的左边还是右边，
     * 从而来调整左右边界Low和high
     * @param nums
     * @param target
     * @return
     */
    public int searchSolution2(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            // 先根据nums[mid]与nums[low]的关系判断mid是在左段还是右段
            // mid在左段
            if (nums[mid] >= nums[low]) {
                // 再判断target是在mid的左边还是右边，从而调整左右边界low和high
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
