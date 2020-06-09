package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/7 22:37
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode54 螺旋矩阵 MEDIUM
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode54 {
    /**
     * 方法一： 模拟
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrderSolution1(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, directionIdx = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIdx][0], nextCol = col + directions[directionIdx][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIdx = (directionIdx+1) % 4;
            }
            row += directions[directionIdx][0];
            col += directions[directionIdx][1];
        }
        return order;
    }

    public List<Integer> spiralOrderSolution2(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                order.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    order.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[right][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
