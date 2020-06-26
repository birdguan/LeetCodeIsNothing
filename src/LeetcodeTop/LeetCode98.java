package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 14:13
 */

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * LeetCode98 验证二叉搜索树 MEDIUM
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode98 {
    public class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     */
    public boolean isValidBSTSolution1(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!helper(node.left, lower, val)) return false;
        if (!helper(node.right, val, upper)) return false;
        return true;
    }

    /**
     * 基于栈的中序遍历
     */
    public boolean isValidBSTSolution2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 基于递归的中序遍历
     */
    double inorder2 = - Double.MAX_VALUE;
    public boolean isValidBSTSolution3(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root != null) {
            if (root.left != null && !helper(root.left)) return false;
            if (root.val <= inorder2) return false;
            inorder2 = root.val;
            System.out.println(inorder2);
            if (root.right != null && !helper(root.right)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        LeetCode98 leetCode98 = new LeetCode98();
        TreeNode node5 = leetCode98.new TreeNode(5);
        TreeNode node1 = leetCode98.new TreeNode(1);
        TreeNode node4 = leetCode98.new TreeNode(4);
        TreeNode node3 = leetCode98.new TreeNode(3);
        TreeNode node6 = leetCode98.new TreeNode(6);
        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node3.right = node6;
        System.out.println(leetCode98.isValidBSTSolution3(node5));
    }
}
