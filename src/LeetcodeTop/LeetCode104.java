package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 19:01
 */

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode104 二叉树的最大深度 EASY
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
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
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode104 {
    class TreeNode {
        private int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(log(n)) - O(n)
     * @param node
     * @return
     */
    public int maxDepthSolution1(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = maxDepthSolution1(node.left);
        int rightHeight = maxDepthSolution1(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 方法二：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param node
     * @return
     */
    public int maxDepthSolution2(TreeNode node) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (node != null) {
            queue.offer(new Pair<>(node, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            node = cur.getKey();
            int currDepth = cur.getValue();
            depth = Math.max(depth, currDepth);
            if (node.left != null) queue.add(new Pair<>(node.left, currDepth + 1));
            if (node.right != null) queue.add(new Pair<>(node.right, currDepth + 1));
        }
        return depth;
    }
}
