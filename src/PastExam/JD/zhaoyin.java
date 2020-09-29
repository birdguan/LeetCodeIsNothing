package PastExam.JD;

import java.util.HashSet;
import java.util.Set;

public class zhaoyin {
    public static int getMaxCount(int[] queueNums) {
        int maxCount = 0;
        Set<Integer> queueNumSet = new HashSet<>();
        for (int queueNum : queueNums) {
            queueNumSet.add(queueNum);
        }
        for (int queueNum : queueNumSet ) {
            if (!queueNumSet.contains(queueNum-1)) {
                int curNum = queueNum;
                int curCount = 1;
                while (queueNumSet.contains(curNum+1)) {
                    curNum+=1;
                    curCount += 1;
                }
                maxCount = Math.max(curCount, maxCount);
            }
        }
        return maxCount;

    }

    public static void main(String[] args) {
        int[] nums = {8,9,25,11,15,26,24,23,22};
        System.out.println(getMaxCount(nums));
    }
}
