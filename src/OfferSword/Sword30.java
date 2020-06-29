package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/29 17:39
 */

import java.util.Stack;

/**
 * Sword30 包含min函数的栈 EASY
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword30 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** initialize your data structure here. */
    public Sword30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            int top = stack1.pop();
            if (!stack2.isEmpty() && stack2.peek() == top) {
                stack2.pop();
            }
        }
    }

    public int top() {
        if (!stack1.isEmpty()) return stack1.peek();
        else return -1;
    }

    public int min() {
        if (!stack2.isEmpty()) return stack2.peek();
        else throw new RuntimeException("空栈");
    }
}
