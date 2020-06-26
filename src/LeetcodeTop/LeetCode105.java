package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 19:34
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode105 从前序与中序遍历序列构造二叉树 MUDIUM
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode105 {
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
     * 空间复杂度：O(n)
     */
    private Map<Integer, Integer> inorderMap;
    public TreeNode buildTreeSolution1(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder,
                            int preorderLeft, int preorderRight,
                            int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) return null;
        int inorderRoot = inorderMap.get(preorder[preorderLeft]);
        int leftSubtreeSize = inorderRoot - inorderLeft;
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        root.left = helper(preorder, inorder,
                preorderLeft+1, preorderLeft + leftSubtreeSize,
                inorderLeft, inorderRoot-1);
        root.right = helper(preorder, inorder,
                preorderLeft + leftSubtreeSize + 1, preorderRight,
                inorderRoot + 1, inorderRight);
        return root;
    }

    /**
     * 方法二：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeSolution2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderValue = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderValue);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderValue);
                stack.push(node.right);
            }
        }
        return root;
    }
}
