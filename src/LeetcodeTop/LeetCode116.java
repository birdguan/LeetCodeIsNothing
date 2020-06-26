package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/22 14:35
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode116 填充每个节点的下一个右侧节点指针 MEDIUM
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    /**
     * 方法一：bfs层序遍历
     * 时间复杂度：O(N)
     * 控件复杂度：O(N)
     * @param root
     * @return
     */
    public Node connectSolution1(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 方法二：使用已建立的next指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 两种情况的next指针：
     * 1. 左节点的next是右节点
     *      node.left.next = node.right
     * 2. 右节点的next是节点next的左节点
     *      node.right.next = node.next.left
     */
    public Node connectSolution2(Node root) {
        if (root == null) return null;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) head.right.next = head.next.left;
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    /**
     * 使用递归的方式利用next指针
     * @param root
     * @return
     */
    public Node connectSolution3(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node node, Node next) {
        if (node != null) {
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null ? node.next.left : null);
        }
    }
}
