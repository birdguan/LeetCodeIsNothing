package PastExam.ShenXinFu.exam2019;


import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/7a1ae529644f4d94819a2a137d59d5c6?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 小明横穿沙漠，需要携带至少x毫升的水。
 *
 * 有两种规格的矿泉水可供选购：小瓶矿泉水每瓶500ml，价格a元。大瓶矿泉水每瓶1500ml，价格b元。
 *
 * 小明打算买一些矿泉水用于横穿沙漠，为了保证至少买到x毫升的水，小明至少需要花费多少钱？
 *
 * 输入描述:
 * 第一行一个正整数t(t<=1000)，表示有t组测试数据;
 *
 * 接下来t行，每行3个正整数：x，a，b。其中x<=1,000,000,000，表示小明至少需要x毫升水；a<=100，b<=100，分别表示小瓶和大瓶矿泉水的价格，单位：元。
 *
 *
 * 输出描述:
 * 每组测试数据输出一行，表示小明最少需要花费的钱，单位：元。
 *
 * 示例1
 * 输入
 * 3
 * 5000 5 10
 * 4999 5 10
 * 5000 5 100
 * 输出
 * 35
 * 35
 * 50
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] data = new int[t][3];
        for (int i = 0; i < t; i++) {
            int total = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (3*a <= b) {
                System.out.println((int)(a * Math.ceil(total/500.0)));
            } else if (a >= b) {
                System.out.println((int)(b * Math.ceil(total/1500.0)));
            } else {
                System.out.println((int)(b * Math.floor(total/1500.0) + a * (Math.ceil(total%1500/500.0))));
            }
        }
    }
}
