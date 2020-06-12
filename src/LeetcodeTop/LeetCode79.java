package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/12 21:15
 */

/**
 * LeetCode79 单词搜索 MEDIUM
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode79 {
    private int rows, cols;
    private String word;
    private char[][] board;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        this.word = word;
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextX = i + directions[k][0];
                int nextY = i + directions[k][1];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]) {
                    if (dfs(nextX, nextY, start+1)) return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
