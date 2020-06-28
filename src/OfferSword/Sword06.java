package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 20:34
 */

import java.util.List;
import java.util.Stack;

/**
 * Sword06 从尾到头打印链表 EASY
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Sword06 {
    class ListNode {
        private int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 辅助栈
     * @param head 链表头结点
     * @return 从尾到头打印结果
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
