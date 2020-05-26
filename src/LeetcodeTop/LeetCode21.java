package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/26 14:01
 */

/**
 * LeetCode21 合并两个有序链表 EASY
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 递归
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsSolution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsSolution1(l1.next, l2);
            return l1;
        }  else {
            l2.next = mergeTwoListsSolution1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsSolution2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
