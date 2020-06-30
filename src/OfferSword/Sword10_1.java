package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/6/28 21:51
 */

/**
 * Sword10_1 斐波那契数列 EASY
 */
public class Sword10_1 {
    public int fib(int n) {
        if (n <= 1) return n;
        int f0 = 0, f1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = f1;
            f1 = (f0 + f1) % 1000000007;
            f0 = tmp;
        }
        return f1;
    }
}
