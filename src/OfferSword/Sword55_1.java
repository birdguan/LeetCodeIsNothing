package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/30 14:22
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sword55_1 二叉树的深度 EASY
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword55_1 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * dfs
     * @param root 二叉树
     * @return 最大深度
     */
    public int maxDepthSolution1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthSolution1(root.left), maxDepthSolution1(root.right)) + 1;
    }

    /**
     * bfs
     * @param root 二叉树
     * @return 最大深度
     */
    public int maxDepthSolution2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
