package Other;

/**
 * @Author: birdguan
 * @Date: 2020/6/12 17:38
 */

/**
 * 经典面试题 高楼扔鸡蛋
 */
public class DropEgg {
    /**
     * 计算扔鸡蛋的次数
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return 扔的次数
     */
    public int superEggDrop(int K, int N) {
        /*
        m: 测试次数
        dp[k][m]: 给定k个鸡蛋投掷m次最多可以测试的楼层
         */
        int[][] dp = new int[K+1][N+1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        DropEgg dropEgg = new DropEgg();
        System.out.println(dropEgg.superEggDrop(2, 100));
    }
}
