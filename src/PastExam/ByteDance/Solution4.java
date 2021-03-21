package PastExam.ByteDance;

import java.util.*;

public class Solution4 {

    /**
     * 笛卡尔积
     * @param dimvalue
     * @param result
     * @param layer
     * @param curList
     */
    private static void descartes(List<List<Integer>> dimvalue, List<List<Integer>> result, int layer, List<Integer> curList) {
        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<Integer> list = new ArrayList<Integer>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<Integer> list = new ArrayList<Integer>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();
        List<List<Integer>> inputList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tempList.add(scanner.nextInt());
            }
            inputList.add(new ArrayList<>(tempList));
        }
        List<List<Integer>> descartedList = new ArrayList<>();
        descartes(inputList, descartedList, 0, new ArrayList<>());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < descartedList.size(); i++) {
            int sum = 0;
            for (int j = 0; j < descartedList.get(i).size(); j++) {
                sum += descartedList.get(i).get(j);
            }
            res.add(sum);
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int max = res.get(res.size() - 1), min = res.get(res.size() - k);
        System.out.println(min + " " + max);
    }
}

/*
3 3 1
3 1 2
2 3 4
3 6 4
 */