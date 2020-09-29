package PastExam.Tencent.exam;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = -1;
        List<List<Integer>> nums = new ArrayList<>();
        for (int group = 0; group < m; group++) {
            int x = scanner.nextInt();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                int num = scanner.nextInt();
                if (num == 0) start = group;
                tempList.add(num);
            }
            nums.add(tempList);
        }
        Set<Integer> visited = new HashSet<>(nums.get(start));
        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums.get(start)) {
            deque.offerLast(num);
        }

        while (!deque.isEmpty()) {
            int compare = deque.removeFirst();
            for (int i = 0; i < m; i++) {
                if (i == start) continue;
                if (nums.get(i).contains(compare)) {
                    for (int num : nums.get(i)) {
                        if (!visited.contains(num)) {
                            deque.offerLast(num);
                            visited.add(num);
                        }
                    }
                }
            }
        }
        System.out.println(visited.size());
    }
}
