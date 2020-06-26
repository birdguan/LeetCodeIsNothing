package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/15 8:59
 */

import java.util.Stack;

/**
 * LeedCode84 柱状图中最大的矩形 HARD
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LeetCode84 {
    /**
     * 单调栈
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return area;
    }
}
