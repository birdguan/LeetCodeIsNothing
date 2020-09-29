package PastExam.PingDuoDuo.exam2021;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[][] newGrid = new int[n][m];
        int soMax = numSo(grid, newGrid);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newGrid[i][j] == 0) {
                    int top = i > 0 ? newGrid[i-1][j] : 0;
                    int down = i < n-1? newGrid[i+1][j] : 0;
                    int left = j > 0 ? newGrid[i][j-1] : 0;
                    int right = j < n-1? newGrid[i][j+1] : 0;
                    System.out.print("i" + i + ", ");
                    System.out.print("j" + j + ": ");
                    System.out.print(" left " + left + ";");
                    System.out.print(" right" + right + ";");
                    System.out.println();
//                    max = Math.max(left + right + top + down, max);
                    max = Math.max(left + right,
                            Math.max(left + top,
                                            Math.max(left + down,
                                                    Math.max(right + top,
                                                            Math.max(right + down,
                                                                    Math.max(top + down, max))))));
                }

            }
        }
        System.out.println(Math.max(soMax, max));
    }

    public static int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int num = 1
                + dfs(grid, row + 1, col)
                + dfs(grid, row - 1, col)
                + dfs(grid, row, col + 1)
                + dfs(grid, row, col - 1);
        grid[row][col] = 1;
        return num;
    }

    public static int numSo(int[][] grid, int[][] newGrid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int num = dfs(grid, i, j);
                    newGrid[i][j] = num;
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }
}
