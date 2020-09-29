package PastExam.MEITUAN;


import java.util.*;

/**
 * 小美的一个兼职是一名跑腿代购员，她有n个订单可以接，订单编号1-n，但是因为订单的时效性，她只能选择其中m个订单接取，
 * 精明的小美当然是希望自己总获利是最大的，已知，一份订单会提供以下信息，跑腿价格v,商品重量w，商品每重1kg，代购费用要
 * 加2元，而一份订单可以赚取到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送外面的，所以自然不会在意自己会累这件事。
 * 请问小美应该选择哪些订单，是的自己获得的钱最多。
 * 请你按照选择的订单号从小到达排序，如果存在多种方案，输出订单编号字典需较小的方案。
 *
 * 测试样例：
 * 5 2
 * 5 10
 * 8 9
 * 1 4
 * 7 9
 * 6 10
 *
 * 2 5
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] profits = new int[n][2];
        for (int i = 0; i < n; i++) {
            int profit = scanner.nextInt() + scanner.nextInt()*2;
            profits[i][0] = profit;
            profits[i][1] = i;
        }
        Arrays.sort(profits, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m; i++) {
            res.append(profits[i][1]+1).append(" ");
        }
        System.out.println(res.toString().trim());

    }

}
