package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/27 23:28
 */


/**
 * LeetCode148 排序链表 MEDIUM
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode148 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 迭代法归并排序
     */

    public ListNode sortList (ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int m = 1; m < len; m *= 2) {
            ListNode pre = dummy;
            cur = pre.next;
            while (cur != null) {
                ListNode first = cur;
                for (int i = 0; i < m - 1 && cur != null; i++) {
                    cur = cur.next;
                }
                if (cur == null) break;
                ListNode second = cur.next;
                cur.next = null;
                cur = second;
                for (int i = 0; i < m - 1 && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode remain = null;
                if (cur != null) {
                    remain = cur.next;
                    cur.next = null;
                }
                cur = remain;
                pre.next = merge(first, second);
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = remain;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;
            } else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }
        if (a != null) {
            cur.next = a;
        }
        if (b != null) {
            cur.next = b;
        }
        return pre.next;
    }
}
