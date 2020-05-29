package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/29 8:54
 */

import java.util.List;

/**
 * LeetCode24 两两交换链表中的节点 MEDIUM
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode24 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param head
     * @return
     */
    public ListNode swapPairsSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head, secondNode = head.next;
        firstNode.next = swapPairsSolution1(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    /**
     * 迭代
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode swapParisSolution2(ListNode head) {
        ListNode dummyNode = new ListNode(-1), curr = dummyNode;
        dummyNode.next = head;
        while ((head != null) && (head.next != null)) {
            ListNode firstNode = head, secondNode = head.next;

            // swapping
            curr.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // reinitializing the head and curr node
            curr = firstNode;
            head = firstNode.next;
        }
        return dummyNode.next;
    }
}
