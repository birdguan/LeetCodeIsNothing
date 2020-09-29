package PastExam.Baidu.exam2021;

import java.util.HashMap;
import java.util.Scanner;

public class Solution3 {
    static HashMap<String, Integer> memo= new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int res = getStepNum(n, m, -1, -1);

        System.out.println(res);
    }

    private static int getStepNum(int n, int m, int last, int lastLast) {
        String key = Integer.toString(n) + ","
                + Integer.toString(last) + ","
                + Integer.toString(lastLast);
        if (memo.containsKey(key)) return memo.get(key);
        int sumStep = 0;
        if (n == 0) return 1;

        for (int i = 1; i <= m; i++) {
            if (n - i >= 0) {
                if (i != last && i != lastLast) {

                    sumStep += getStepNum(n - i, m, i, last) % 1000000007;

                }
            }
        }
        int sum = sumStep % 1000000007;
        memo.put(key, sum);
        return sum;
    }
}
