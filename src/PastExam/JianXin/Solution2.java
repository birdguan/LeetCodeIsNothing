package PastExam.JianXin;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

    }

    public int findFriendNum(int[][] M) {
        int res = 0;
        int m = M.length;
        int[] visited = new int[m];
        if (m == 1) return 1;
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(M, visited, i);
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                dfs(M, visited, j);
            }
        }
    }
}
