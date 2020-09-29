package PastExam.SHEIN;

import java.util.Scanner;

public class Main {
    private static int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chars1 = str1.toCharArray(), chars2 = str2.toCharArray();
        int[] map = new int[128];
        for (int i = 0; i < chars2.length; i++) {
            map[chars2[i]]++;
        }
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int match = chars2.length;
        while (right != chars1.length) {
            map[chars1[right]]--;
            if (map[chars1[right]] >= 0) match--;
            if (match == 0) {
                while (map[chars1[left]] < 0) {
                    map[chars1[left++]]++;
                }
                minLength = Math.min(minLength, right - left + 1);
                match++;
                map[chars1[left++]]++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine(), str2 = scanner.nextLine();
        System.out.println(minLength(str1, str2));
    }
}
