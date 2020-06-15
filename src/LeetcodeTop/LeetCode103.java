package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 17:21
 */

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode103 二叉树的锯齿形层序遍历（二叉树的Z字形遍历） MEDIUM
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode103 {
    private class TreeNode {
        private int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * BFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderSolution1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null)  queue.offerLast(root);
        boolean is_order_left = true;
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                if (is_order_left) {
                    TreeNode node = queue.pollFirst();
                    levelList.add(node.val);
                    if (node.left != null) queue.offerLast(node.left);
                    if (node.right != null) queue.offerLast(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    levelList.add(node.val);
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
            }
            res.add(levelList);
            is_order_left = !is_order_left;
        }
        return res;
    }

    /**
     * DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderSolution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (level >= res.size()) {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(root.val);
            res.add(newLevel);
        } else {
            if (level % 2 == 0) res.get(level).add(root.val);
            else res.get(level).add(0, root.val);
        }
        if (root.left != null) dfs(root.left, level + 1, res);
        if (root.right != null) dfs(root.right, level + 1, res);
    }


}
