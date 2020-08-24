package CompanyExercise.Meituan.exam2020;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 订单分配
 * 链接：https://www.nowcoder.com/questionTerminal/3f495307bfca40e49b0e2b15b14ce923
 * 来源：牛客网
 *
 * 打车派单场景, 假定有N个订单， 待分配给N个司机。每个订单在匹配司机前，会对候选司机进行打分，打分的结果保存在N*N的矩阵A， 其中Aij 代表订单i司机j匹配的分值。
 *
 * 假定每个订单只能派给一位司机，司机只能分配到一个订单。求最终的派单结果，使得匹配的订单和司机的分值累加起来最大，并且所有订单得到分配。
 *
 *
 * 输入描述:
 * 第一行包含一个整数N，2≤N≤10。
 *
 * 第二行至第N+1行包含N*N的矩阵。
 *
 *
 *
 * 输出描述:
 * 输出分值累加结果和匹配列表，结果四舍五入保留小数点后两位
 * （注意如果有多组派单方式得到的结果相同，则有限为编号小的司机分配编号小的订单，比如：司机1得到1号单，司机2得到2号单，就比司机1得到2号单，司机2得到1号单要好）
 * 示例1
 * 输入
 * 3
 * 1.08 1.25 1.5
 * 1.5 1.35  1.75
 * 1.22 1.48 2.5
 * 输出
 * 5.25
 * 1 2
 * 2 1
 * 3 3
 * 说明
 * 第一行代表得到的最大分值累加结果5.25，四舍五入保留两位小数；
 *
 * 第二行至第四行代表匹配的结果[i j],其中i按行递增：
 *
 * 订单1被派给司机2，订单2被派给司机1，订单3被派给司机3。使得A12+ A21+ A33= 1.25 + 1.5 + 2.5 = 5.25在所有的组合中最大。
 */
public class Solution3 {
    private static boolean[] isUsed;
    private static int[] resPath;
    private static double[][] order;
    private static double max = -1;
    private static int[] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        order = new double[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                order[i][j] = scanner.nextDouble();
            }
        }
        isUsed = new boolean[n];
        path = new int[n];
        resPath = new int[n];
        dfs(0, path, 0);
        System.out.println(String.format("%.2f", max));
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + " " + resPath[i]);
        }
    }

    public static void dfs(int now, int[] path, double value) {
        if (now < path.length) {
            for (int i = 0; i < path.length; i++) {
                if (!isUsed[i]) {
                    path[now] = i+1;
                    isUsed[i] = true;
                    dfs(now+1, path, value+order[now][i]);
                    isUsed[i] = false;
                }
            }
        } else {
            if (value > max) {
                max = value;
                System.arraycopy(path, 0, resPath, 0, path.length);
            }
        }
    }
}
