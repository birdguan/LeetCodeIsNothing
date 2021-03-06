package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 9:22
 */

/**
 * LeetCode48 旋转图像 MEDIUM
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode48 {
    /**
     * 方法一：转置后翻转
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param matrix
     */
    public void rotateSolution1(int[][] matrix) {
        int rows = matrix.length;
        // transpose
        for (int row = 0; row < rows; row++) {
            for (int col = row; col < rows; col++) {
                int tmp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = tmp;
            }
        }
        // flip
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows/2; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[row][rows - col - 1];
                matrix[row][rows - col - 1] = tmp;
            }
        }
    }
}
