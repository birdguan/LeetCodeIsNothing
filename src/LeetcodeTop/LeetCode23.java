package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/28 14:10
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode23 合并k个排序链表 HARD
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode23 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 一、K指针：K个指针分别指向K条链表
     */

    /**
     * 每次O(K)比较K个指针求min，时间复杂度O(NK)
     * @param lists
     * @return
     */
    public ListNode mergeKListsSolution1_1(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue;
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) break;
            curr.next = minNode;
            curr = curr.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    /**
     * 使用小根堆对solution1_1进行优化，每次O(logK)比较K个指针求min，时间复杂度O(NlogK)
     * @param lists
     * @return
     */
    public ListNode mergeKListsSolution1_2(ListNode[] lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) priorityQueue.offer(node);
        }
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        while (!priorityQueue.isEmpty()) {
            ListNode minNode = priorityQueue.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) priorityQueue.offer(minNode.next);
        }
        return dummyHead.next;
    }

    /**
     * 逐一合并两条链表
     */
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1), curr = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

    /**
     * 逐一合并两条链表，时间复杂度O(NK)
     * @param lists
     * @return
     */
    public ListNode mergeKListsSolution2_1(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = merge2Lists(res, list);
        }
        return res;
    }

    /**
     * 两两合并对1进行优化，时间复杂度O(NlogK)
     * @param lists
     * @return
     */
    public ListNode mergeKListsSolution2_2(ListNode[] lists) {
        if (lists.length == 0) return null;
        // k表示需要合并的链表条数
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i+1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }
}
