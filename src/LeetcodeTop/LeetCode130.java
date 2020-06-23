package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/23 16:31
 */

/**
 * LeetCode130 被围绕的区域 MEDIUM
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode130 {
    private int rows, cols;
    /**
     * 方法一：dfs递归
     * @param board 二维矩阵
     */
    public void solveSolution1(char[][] board) {
        if (board == null || board.length == 0) return;
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isEdge = i == 0 || i == rows - 1 || j == 0 || j == cols - 1;
                if (isEdge && board[i][j] == 'O') dfsSolution1(board, i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfsSolution1(char[][] board, int i, int j) {
        if ( i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfsSolution1(board, i-1, j);
        dfsSolution1(board, i+1, j);
        dfsSolution1(board, i, j-1);
        dfsSolution1(board, i, j+1);
    }


}
