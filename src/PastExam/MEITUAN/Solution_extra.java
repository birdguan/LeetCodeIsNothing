//package PastExam.MEITUAN;
//
//import java.util.Scanner;
//
//public class Solution_extra {
//    private static int[] nums;
//    private static int x, y;
//    private static boolean[] isUsed;
//    private static int[] resArray;
//    private static int[] array;
//    private static int sum;
//    private static double max = -1;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] line1 = scanner.nextLine().split(" ");
//        x = Integer.parseInt(line1[0]);
//        y = Integer.parseInt(line1[1]);
//        isUsed = new boolean[x];
//        array = new int[x];
//        resArray = new int[x];
//        nums = new int[x+y];
//        String[] line2 = scanner.nextLine().split(" ");
//        for (int i = 0; i < x + y; i++) {
//            nums[i] = Integer.parseInt(line2[i]);
//            sum += nums[i];
//        }
//        dfs(0, array, 0);
//        char[] res = new char[x+y];
//        for (int i = 0; i < x+y; i++) {
//            res[i] = 'B';
//        }
//        for (int idx : resArray) {
//            res[idx] = 'A';
//        }
//        System.out.println(String.valueOf(res));
//    }
//
//
//    public static void dfs(int now, int[] array, double value) {
//        if (now < array.length) {
//            for (int i = 0; i < array.length; i++) {
//                if (!isUsed[i]) {
//                    array[now] = i+1;
//                    isUsed[i] = true;
//
//                    dfs(now+1, array, value+order[now][i]);
//                    isUsed[i] = false;
//                }
//            }
//        } else {
//            if (value > max) {
//                max = value;
//                System.arraycopy(array, 0, resArray, 0, path.length);
//            }
//        }
//    }
//}
