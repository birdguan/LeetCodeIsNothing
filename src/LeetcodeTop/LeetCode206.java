package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 14:34
 */

/**
 * LeetCode206 翻转链表 EASY
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode206 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 迭代法
     * @param head 链表头结点
     * @return 翻转后的链表头结点
     */
    public ListNode reverseListSolution1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }


    /**
     * 递归法
     * @param head 链表头结点
     * @return 翻转后的链表头结点return
     */
    public ListNode reverseListSolution2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = reverseListSolution2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
