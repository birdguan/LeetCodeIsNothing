package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/29 17:29
 */

/**
 * Sword29 顺时针打印矩阵 EASY
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword29 {
    int[] yDirections = {1, 0, -1, 0};
    int[] xDirections = {0, 1, 0, -1};
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows*cols];
        boolean[][] visited = new boolean[rows][cols];
        int x = 0, y = 0, directionIdx = 0;
        for (int i = 0; i < rows*cols; i++) {
            res[i] = matrix[x][y];
            visited[x][y] = true;
            int nextX = x + xDirections[directionIdx];
            int nextY = y + yDirections[directionIdx];
            if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || visited[nextX][nextY]) {
                directionIdx = (directionIdx + 1) % 4;
                nextX = x + xDirections[directionIdx];
                nextY = y + yDirections[directionIdx];
            }
            x = nextX;
            y = nextY;
        }
        return res;
    }
}
