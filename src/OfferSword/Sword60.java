package OfferSword;

/**
 * @Author: birdguan
 * @Date: 2020/7/20 16:37
 */

/**
 * Sword60 n个骰子的点数 EASY
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword60 {
    /**
     * 动态规划
     * @param n 骰子数量
     * @return 所有可能出现值的概率
     */
    public double[] twoSum(int n) {
        double[] pre = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};
        for (int idx = 2; idx <= n; idx++) {
            double[] tmp = new double[idx*5 + 1];
            for (int i = 0; i < pre.length; i++) {
                for (int j = 0; j < 6; j++) {
                    tmp[i+j] += pre[i]/6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
