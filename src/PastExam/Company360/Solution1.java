package PastExam.Company360;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Deque<Integer> enterQueue = new LinkedList<>(), quitQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int enter = scanner.nextInt();
            int quit = scanner.nextInt();
            if (enterQueue.contains(enter)) {
                System.out.println(enter);
                return;
            }
            enterQueue.offerLast(enter);
            quitQueue.offerLast(quit);
        }
        Set<Integer> res = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (!enterQueue.contains(i) && !quitQueue.contains(i)) {
                res.add(i);
            }
        }

        if (enterQueue.peekFirst() == (quitQueue.peekLast()) ||
                (enterQueue.peekFirst() == enterQueue.peekLast() && quitQueue.peekLast() == 0) ||
                (quitQueue.peekFirst() == quitQueue.peekLast() && enterQueue.peekFirst() == 0)) {
            res.add(enterQueue.peek());
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : res) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

/*
5 2
1 1
1 0

3 2
1 1
2 0


 */
