package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/31 18:59
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode36 有效的数独 MEDIUM
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rowsMap = new HashMap[9];
        HashMap<Integer, Integer>[] colsMap = new HashMap[9];
        HashMap<Integer, Integer>[] boxesMap = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rowsMap[i] = new HashMap<>();
            colsMap[i] = new HashMap<>();
            boxesMap[i] = new HashMap<>();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    int n = (int)num;
                    int boxIdx = (row / 3) * 3 + col / 3;
                    rowsMap[row].put(n, rowsMap[row].getOrDefault(n, 0) + 1);
                    colsMap[col].put(n, colsMap[col].getOrDefault(n, 0) + 1);
                    boxesMap[boxIdx].put(n, boxesMap[boxIdx].getOrDefault(n, 0) + 1);

                    if (rowsMap[row].get(n) > 1 || colsMap[col].get(n) > 1 || boxesMap[boxIdx].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
