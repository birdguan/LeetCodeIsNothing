package PastExam.Qianxin.exam2021;

import java.util.*;


public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin int整型一维数组 抛硬币的结果
     * @param n int整型 连续是正面的次数
     * @return int整型
     */
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        int maxRes = 0;
        for (int i = 0; i < candies.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (coin[j] == 0) max += candies[j];
            }
            for (int j = i; j < i+n && j < candies.length; j++) {
                max += candies[j];
            }
            for (int j = i+n; j < candies.length; j++) {
                if (coin[j] == 0) max += candies[j];
            }
            if (max > maxRes) maxRes = max;
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int[] candies = {3,5,7,2,8,8,15,3};
        int[] coin = {1,0,1,0,1,0,1,0};
        int n = 3;
        System.out.println(maxCandies(candies, coin, n));
    }
}
