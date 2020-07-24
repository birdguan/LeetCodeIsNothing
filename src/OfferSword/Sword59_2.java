package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/24 9:41
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Sword59_2 队列的最大值 MEDIUM
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword59_2 {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public Sword59_2() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.size() > 0 ? deque.peekFirst() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (deque.size() > 0 && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        int tmp = queue.size() > 0 ? queue.poll() : -1;
        if (deque.size() > 0 && deque.peekFirst().equals(tmp)) {
            deque.pollFirst();
        }
        return tmp;
    }
}
