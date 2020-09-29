package PastExam.Qianxin.exam2021;

import java.util.*;


public class Solution2 {
    /**
     * 获得剩余区域内的最大干净矩形面积
     * @param x1 int整型
     * @param y1 int整型
     * @param x2 int整型
     * @param y2 int整型
     * @param x3 int整型
     * @param y3 int整型
     * @param x4 int整型
     * @param y4 int整型
     * @return int整型
     */
    public int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x1 == x2 || y1 == y2 || x3 == x4 || y3 == y4) {
            return 100;
        }
        // write code here
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = x3; i < x4; i++) {
            for (int j = y3; j < y4; j++) {
                matrix[i][j] = 0;
            }
        }
        return findMaxRectangleSize(matrix);
    }

    public int findMaxRectangleSize(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == 1) heights[j] += 1;
                else heights[j] = 0;
            }
            max = Math.max(max, findMaxRectangleSizeSingleRows(heights));
        }
        return max;
    }

    public int findMaxRectangleSizeSingleRows(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int maxSize = 0;
        int curSize = 0;
        int curHeight = 0;
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (stack.empty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            }
            else {
                curHeight = arr[stack.pop()];
                curSize = curHeight * (stack.empty() ? i : i - stack.peek() - 1);
                maxSize = Math.max(maxSize, curSize);
            }
        }

        while (!stack.empty()) {
            curHeight = arr[stack.pop()];
            curSize = curHeight * (stack.empty() ? i : i - stack.peek() - 1);
            maxSize = Math.max(maxSize, curSize);
        }
        return maxSize;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.getMaxArea(0,0,1,1,9,9,10,10));
    }
}
