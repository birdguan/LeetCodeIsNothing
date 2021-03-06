package CompanyExercise.Meituan.exam2020;


import java.util.Scanner;

/**
 * 字符串模式匹配
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        String s = scanner.nextLine();
        int res = solution2.isMatch(s, p) ? 1 : 0;
        System.out.println(res);
    }
}
