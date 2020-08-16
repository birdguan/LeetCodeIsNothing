package LeetcodeTop;

import java.util.Random;

/**
 * LeetCode384 打乱数组 MEDIUM
 * 打乱一个没有重复元素的数组。
 *
 *  
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode384 {
    private int[] array;
    private int[] original;

    Random random = new Random();

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + max;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public LeetCode384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    private int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    private int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }
        return array;
    }
}
