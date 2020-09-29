package PastExam.Bilibili.exam2011;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static int GetFragment (String str) {
        // write code here
        if (str.equals(" ") || str.length() == 0) return 0;
        List<Integer> list = new ArrayList<>();
        int len = str.length();
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int n = list.size();
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum / n;
    }

    public static void main(String[] args) {
        int res = GetFragment("aaabbaaac");
        System.out.println(res);
    }

}
