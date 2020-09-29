package PastExam.Shopee;

import java.util.*;

public class Solution2 {
    private static List<String> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < n; t++) {
            String originString = scanner.nextLine();
            String targetString = scanner.nextLine();
            int[] orgin = new int[8];
            int[] target = new int[8];
            for (int i = 0; i < 8; i++) orgin[i] = Integer.parseInt(originString.substring(i, i+1));
            for (int i = 0; i < 8; i++) target[i] = Integer.parseInt(targetString.substring(i, i+1));
            Deque<String> choiceList = new LinkedList<>();
            Deque<int[]> originList = new LinkedList<>();
            choiceList.add("");
            originList.add(orgin);
            bfs(target, choiceList, originList);

        }
    }

    private static void bfs(int[] target, Deque<String> choiceList, Deque<int[]> originList) {

        for (int i = 0; i < choiceList.size(); i++) {
            String choice = choiceList.pollFirst();
            int[] origin = originList.pollFirst();
            for (int j = 0; j < 3; j++) {
                char type = (char) ('A' + j);
                int[] copy = Arrays.copyOf(origin, 8);
                tranform(copy, String.valueOf(type));
                if (Arrays.equals(copy, target)) {
                    System.out.println(choice + type);
                    return;
                }
                choiceList.offerLast(choice + type);
                originList.offerLast(copy);
            }
        }
        bfs(target, choiceList, originList);

    }

    private static void tranform(int[] origins, String type) {
        if (type.equals("A")) {
            for (int i = 0; i < origins.length/2; i++) {
                int tmp = origins[i];
                origins[i] = origins[origins.length - 1 - i];
                origins[origins.length - 1 - i] = tmp;
            }
        } else if (type.equals("B")) {
            int pos3 = origins[3];
            for (int i = 1; i <= 3; i++) {
                origins[i] = origins[i-1];
            }
            origins[3] = pos3;
            int pos4 = origins[4];
            for (int i = 6; i >= 4; i--) {
                origins[i] = origins[i+1];
            }
            origins[7] = pos4;
        } else {
            int pos1 = origins[1], pos2 = origins[2], pos5 = origins[5], pos6 = origins[6];
            origins[1] = pos6;
            origins[2] = pos1;
            origins[5] = pos2;
            origins[6] = pos5;
        }
    }
}


/*
1
12345678
17245368

2
12345678
17245368
12345678
82754631
 */