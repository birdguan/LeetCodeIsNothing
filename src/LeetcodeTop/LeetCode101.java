package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 16:07
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode101 对称二叉树 EASY
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode101 {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public boolean isSymmetricSolution1(TreeNode root) {
        return checkSolution1(root, root);
    }

    private boolean checkSolution1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && checkSolution1(p.left, q.right) && checkSolution1(p.right, q.left);
    }

    /**
     * 方法二：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public boolean isSymmetricSolution2(TreeNode root) {
        return checkSolution2(root, root);
    }

    private boolean checkSolution2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
