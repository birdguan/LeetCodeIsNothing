package PastExam.MEITUAN;

import java.util.Scanner;


/**
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。
 * 已知货物入库的时候是按顺序堆放在一起，如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以
 * 保证货物局部的顺序不变。
 *
 * 已知货物最初是按1-n的顺序堆放的，每件货物的重量为w_i，小美会根据单据依次不妨会地取出货物，请问按照上述操作，小美每取出一件
 * 货物之后，重量和最大的一堆货物是多少？
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counts = Integer.parseInt(scanner.nextLine());
        int[] weights = new int[counts];
        int[] idxs = new int[counts];
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        for (int i = 0; i < counts; i++) {
            weights[i] = Integer.parseInt(line1[i]);
            idxs[i] = Integer.parseInt(line2[i])-1;
        }
        int[] sumList = new int[counts];
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j <= i; j++) {
                sumList[i] += weights[j];
            }
        }
        for (int idx : idxs) {
            for (int j = idx; j < counts; j++) {
                sumList[j] -= weights[idx];
            }
            int left = sumList[idx];
            int right = sumList[counts-1] - left;
            int max = Math.max(left, right);
            System.out.println(max);
        }

    }
}
