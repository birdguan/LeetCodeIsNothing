package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/7 20:39
 */

import java.util.Stack;

/**
 * Sword 33 二叉搜索树的后序遍历 MEDIUM
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword33 {
    /**
     * 方法一：递归分治
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * @param postorder 后序遍历数组
     * @return 是否二叉搜索树的后序遍历
     */
    public boolean verifyPostorderSolution1(int[] postorder) {
        return recur(postorder, 0, postorder.length);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int p = left;
        while (postorder[p] < postorder[right]) p++;
        int rightMarker = p;
        while (postorder[p] > postorder[right]) p++;
        return p == right && recur(postorder, left, rightMarker - 1) && recur(postorder, rightMarker, right);
    }

    /* -------------------------------------------------------------------------- */

    /**
     * 方法二：辅助单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param postorder
     * @return
     */
    public boolean verifyPostorderSolution2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
