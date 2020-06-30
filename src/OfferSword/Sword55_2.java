package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/30 14:44
 */

/**
 * Sword55_2
 *
 */
public class Sword55_2 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 后序遍历 + 剪枝
     * @param root 二叉树根节点
     * @return 是否平衡二叉树
     */
    public boolean isBalancedSolution1(TreeNode root) {
        return helper(root) != -1;
    }

    /*-----------------------------------------
    * 计算节点的最大深度，若不平衡，直接返回-1；
    * ------------------------------------- */
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return  -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    /**
     * 方法二：先序遍历+判断深度
     * @param root 二叉树根节点
     * @return 是否平衡二叉树
     */
    public boolean isBalancedSolution2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2
                && isBalancedSolution2(root.left)
                && isBalancedSolution2(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
