package PastExam.JD;

import java.util.Scanner;

public class Solution2 {
    private static int rows, cols;
    private static int startX, startY;
    private static char[][] matrix;
    private static boolean[][] visited;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean isSuccess;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] lines = scanner.nextLine().split(" ");
            rows = Integer.parseInt(lines[0]);
            cols = Integer.parseInt(lines[1]);
            matrix = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                    if (matrix[i][j] == 'S') {
                        startX = i; startY = j;
                    }
                }
            }
            isSuccess = false;
            dfs(startX, startY);
            String res = isSuccess ? "YES" : "NO";
            System.out.println(res);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        if (matrix[x][y] == '#') return;
        if (matrix[x][y] == 'E') {
            isSuccess = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if (nextX >=0 && nextX < rows &&
                    nextY >= 0 && nextY < cols &&
                    !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
