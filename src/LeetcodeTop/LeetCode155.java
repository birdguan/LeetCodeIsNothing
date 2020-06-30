package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 9:10
 */

import java.util.Stack;

/**
 * LeetCode155 最小栈 EASY
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode155 {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public LeetCode155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    /* -----------------------------------------------------
    * 方法一：数据栈和辅助栈同步
    * ---------------------------------------------------- */
    public void pushSolution1(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void popSolution1() {
        if(!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int topSolution1() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public int getMinSolution1() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }


    /* --------------------------------------------------------
     * 数据栈和辅助栈不同步
     * ------------------------------------------------------- */
    public void pushSolution2(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void popSolution2() {
        if (!data.isEmpty()) {
            int top = data.pop();
            if (helper.peek() == top) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }
}
