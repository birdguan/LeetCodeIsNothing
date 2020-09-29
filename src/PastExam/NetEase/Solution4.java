//package PastExam.NetEase;
//
//import java.util.*;
//
//public class Solution4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] manStrs = scanner.nextLine().split(" ");
//        int[] manIds = new int[manStrs.length];
//        for (int i = 0; i < manIds.length; i++) manIds[i] = Integer.parseInt(manStrs[i]);
//        String[] womanStrs = scanner.nextLine().split(" ");
//        int[] womanIds = new int[womanStrs.length];
//        System.out.println(Math.min(manIds.length, womanIds.length));
//
//        for (int i = 0; i < womanIds.length; i++) womanIds[i] = Integer.parseInt(womanStrs[i]);
//        int n = Integer.parseInt(scanner.nextLine());
//        int [] gender = new int[manIds.length + womanStrs.length];
//        for (int id : manIds) gender[id] = 1;
//        List<List<Integer>> matches = new ArrayList<>();
//        for (int i = 0; i < manIds.length + womanStrs.length; i++) {
//            matches.add(new ArrayList<>());
//        }
////        Map<Integer, List<Integer>> manMap = new HashMap<>();
////        for (int id : manIds) {
////            manMap.put(id, new ArrayList<>());
////        }
////        Map<Integer, List<Integer>> womanMap = new HashMap<>();
////        for (int id : womanIds) {
////            womanMap.put(id, new ArrayList<>());
////        }
//        for (int i = 0; i < n; i++) {
//            String[] line = scanner.nextLine().split(" ");
//            int manId = Integer.parseInt(line[0]);
//            int womanId = Integer.parseInt(line[1]);
//            matches.get(manId).add(womanId);
//            matches.get(womanId).add(manId);
//        }
//        List<List<Integer>> manMatches = new ArrayList<>();
//        for (int i = 0; i < matches.size(); i++) {
//            if (gender[i] == 1) {
//                manMatches.add(matches.get(i));
//            }
//        }
//        manMatches.sort(new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return o1.size() - o2.size();
//            }
//        });
//
//        boolean[] status = new boolean[manIds.length + womanIds.length];
//        int count = 0;
//        for (List<Integer> match : manMatches) {
//            if ()
//        }
//        Set<Integer> visited = new HashSet<>();
////        boolean hasResult = true;
////        while (hasResult) {
////            hasResult = false;
////            int man = 0, woman = 0, minLne = Integer.MAX_VALUE;
////            for (int manId : manMap.keySet()) {
////
////            }
////        }
//
//    }
//}
