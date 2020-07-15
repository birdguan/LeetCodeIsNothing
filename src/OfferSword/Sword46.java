package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/12 22:45
 */

/**
 * Sword46 把数字翻译成字符串 MEDUIM
 *　给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int dp1 = 0, dp2 = 1, res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = dp2;
            if (i > 0 && str.substring(i-1, i+1).compareTo("25")<=0
                    && str.substring(i-1, i+1).compareTo("10") >= 0) {
                res += dp1;
            }
            dp1 = dp2;
            dp2 = res;

        }
        return res;
    }

    public static void main(String[] args) {
        Sword46 sword46 = new Sword46();
        int res = sword46.translateNum(25);
    }
}
