package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/23 19:51
 */

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode138 复制带随机指针的链表 MEDIUM
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode138 {
    class Node {
        private int val;
        private Node next;
        private Node random;

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    Map<Node, Node> copiedMap = new HashMap<>();
    /**
     * 方法一：回溯，把链表看做一张图
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head 头结点
     * @return 深度拷贝结果
     */
    public Node copyRandomListSolution1(Node head) {
        if (head == null) return null;
        if (copiedMap.containsKey(head)) return copiedMap.get(head);
        Node node = new Node(head.val, null, null);
        copiedMap.put(head, node);
        node.next = copyRandomListSolution1(head.next);
        node.random = copyRandomListSolution1(head.random);
        return node;
    }

    /* ------------------------------------------------ */

    /**
     * 方法二：O(1)空间的迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 头结点
     * @return 深度拷贝结果
     */
    public Node copyRandomListSolution2(Node head) {
        if (head == null) return null;

        Node ptr = head;

        // A -> A' -> B -> B' -> C -> C'
        while (ptr != null) {
            Node newNode = new Node(ptr.val, null, null);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;
        while (ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Node ptrOld = head;
        Node ptrNew = head.next;
        Node headNew = head.next;
        while (ptrOld != null) {
            ptrOld.next = ptrOld.next.next;
            ptrNew.next = ptrNew.next != null ? ptrNew.next.next : null;
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }
        return headNew;
    }

}
