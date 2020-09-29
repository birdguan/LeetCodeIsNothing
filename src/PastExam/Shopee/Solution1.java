package PastExam.Shopee;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int left = 0, right = str.length()-1;
        for (; left < right; left++) {
            char ch = chars[left];
            if ((ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch < 'z')) {
                while (!((chars[right] >= 'A' && chars[right] <= 'Z'
                        || chars[right] >= 'a' && chars[right]  < 'z'))) {
                    right--;
                }
                if (right < left) break;
                char rightChar = chars[right];
                chars[right] = chars[left];
                chars[left] = rightChar;
                right--;
            }
        }
        System.out.println(new String(chars));
    }
}
