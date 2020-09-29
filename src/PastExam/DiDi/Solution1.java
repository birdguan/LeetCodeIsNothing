//package PastExam.DiDi;
//
//import java.util.*;
//
//public class Solution1 {
//    private static boolean[] visited;
//    private static int visitedNum;
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        for (int t = 0; t < count; t++) {
//            int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
//            List<List<Integer>> islands = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                islands.add(new ArrayList<>());
//            }
//            for (int i = 0; i < m; i++) {
//                int from = scanner.nextInt();
//                int to = scanner.nextInt();
//                int cost = scanner.nextInt();
//                if (cost <= k) {
//                    islands.get(from).
//                }
//            }
//            Map<Integer, List<Integer>> fromMap = new HashMap<>();
//            Map<Integer, List<Integer>> toMap = new HashMap<>();
//            int start = -1;
//            for (int i = 0; i < m; i++) {
//                int from = scanner.nextInt();
//                int to = scanner.nextInt();
//                int cost = scanner.nextInt();
//                if (i == 0) start = from;
//                if (cost <= k) {
//                    if (!fromMap.containsKey(from)) {
//                        fromMap.put(from, new ArrayList<>());
//                    }
//                    fromMap.get(from).add(to);
//                    if (!toMap.containsKey(to)) {
//                        toMap.put(to, new ArrayList<>());
//                    }
//                    toMap.get(to).add(from);
//
//                }
//            }
//            Set<Integer> visited = new HashSet<>();
//            Deque<Integer> deque = new LinkedList<>();
//            deque.offerLast(start);
//            while (!deque.isEmpty()) {
//                start = deque.pollFirst();
//                visited.add(start);
//                if (fromMap.containsKey(start)) {
//                    List<Integer> list = fromMap.get(start);
//                    for (int island : list) {
//                        if (!visited.contains(island)) {
//                            deque.offerLast(island);
//                        }
//                    }
//                } else if (toMap.containsKey(start)) {
//                    List<Integer> list = toMap.get(start);
//                    for (int island : list) {
//                        if (!visited.contains(island)) {
//                            deque.offerLast(island);
//                        }
//                    }
//                }
//            }
//            String res = visited.size() == n ? "Yes" : "No";
//            System.out.println(res);
//        }
//
//
//    }
//
//    private static boolean canVisitedIslands(List<List<Integer>> islands) {
//        int n = islands.size();
//        visited = new boolean[n];
//        dfs(islands, 0);
//        return visitedNum == n;
//    }
//
//    private static void dfs(List<List<Integer>> islands, int x) {
//        visited[x] = true;
//        visitedNum++;
//        List<Integer> list = islands.get(x);
//        for (int next : list) {
//            if (!visited[next]) {
//                dfs(islands, next);
//            }
//        }
//    }
//}
//
//
///*
//2
//3 3 400
//1 2 200
//1 3 300
//2 3 500
//3 3 400
//1 2 500
//1 3 600
//2 3 700
// */