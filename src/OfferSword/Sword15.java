package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/29 9:57
 */

/**
 * Sword15 二进制中1的个数 EASY
 */
public class Sword15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
