//package PastExam.Vivo;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//
//public class Solution1 {
//    private static int rows, cols;
//    private static int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0},
//            {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
//
//    public static void main(String[] args) {
//
//
//    }
//
//    private int shortestPath(int[][] grid, int startX, int startY, int endX, int endY) {
//        rows = grid.length;
//        cols = grid[0].length;
//        if (grid[startX][startY] == 1 || grid[endX][endY] == 1) return -1;
//        Queue<int[]> pos = new LinkedList<>();
//        pos.add(new int[] {startX, startY});
//        while (!pos.isEmpty() && grid[endX][endY] == 0) {
//            int[] xy = pos.remove();
//            int preLength = grid[xy[0]][xy[1]];
//            for (int i = 0; i < 8; i++) {
//                int newX = xy[0] + directions[i][0];
//                int newY = xy[1] + directions[i][1];
//                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
//                    pos.add(new int[]{newX, newY});
//                    grid[newX][newY]
//                }
//            }
//
//        }
//    }
//}
