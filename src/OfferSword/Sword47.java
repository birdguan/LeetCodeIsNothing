package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/15 17:41
 */

import java.util.Map;

/**
 * Sword47 礼物的最大价值 MEDIUM
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword47 {
    /**
     * 动态规划
     * 时间复杂度：O(MN)
     * 空间复杂度：O(1)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int col = 1; col < cols; col++) grid[0][col] += grid[0][col-1];
        for (int row = 1; row < rows; row++) grid[row][0] += grid[row][0];
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                grid[row][col] += Math.max(grid[row-1][col], grid[row][col-1]);
            }
        }
        return grid[rows-1][cols-1];
    }
}
