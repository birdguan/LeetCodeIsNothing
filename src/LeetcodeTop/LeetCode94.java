package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 13:02
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode94 二叉树的中序遍历 MEDIUM
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode94 {
    public class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) helper(root.left, res);
            res.add(root.val);
            if (root.right != null) helper(root.right, res);
        }
    }

    /**
     * 方法二：基于栈的遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
