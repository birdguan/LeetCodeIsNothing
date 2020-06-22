package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/22 9:25
 */

/**
 * LeetCode108 将有序数组转换为二叉搜索数 EASY
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode108 {
    class TreeNode {
        private int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 将有序数组转换为二叉搜索树的结果是**不唯一的**、
     *
     * - 关于BST的一些知识：
     *   - 中序遍历不能唯一确定一棵二叉搜索树
     *   - 先序遍历和后序遍历不能唯一确定一棵二叉树
     *   - 中序+先序、中序+后序可以确定唯一一棵二叉树
     *
     */

    private int[] nums;

    /**
     * 方法一：中序遍历，始终选择中间位置左边元素作为根节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper1(int left, int right) {
        if (left > right) return null;

        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper1(left, p-1);
        root.right = helper1(p+1, left);
        return root;
    }

    /**
     * 方法二：中序遍历，始终选择中间位置的右边元素作为根节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper2(int left, int right) {
        if (left > right) return null;
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) p++;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper2(left, p-1);
        root.right = helper2(p+1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper1(0, nums.length - 1);
    }

}
