package PastExam.ABC;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    public static double shannon(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        double sum = 0;
        for (Character key : map.keySet()) {
            int count = map.get(key);
            sum += (double)count/n * (Math.log((double)count/n)/Math.log(2));
        }

        return -sum;
    }
    public static void main(String[] args) {
        double res = shannon("AABB");
        System.out.println(String.format("%.2f", res));
    }
}
