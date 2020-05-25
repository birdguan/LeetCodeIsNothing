package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/25 8:56
 */

/**
 * LeetCode19  删除列表的倒数第N个节点 MEDIUM
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode19 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 两遍遍历算法
     * 第一遍：得到链表的长度length，第二遍：删除倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndSolution1(ListNode head, int n) {
        // 设置哑节点是为了处理极端情况，如链表中只有一个节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 第一遍遍历，获得链表的长度length
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        length -= n;
        curr = dummy;
        while (length > 0) {
            curr = curr.next;
            length--;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    /**
     * 一遍遍历算法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndSolution2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 1; i <= n+1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
