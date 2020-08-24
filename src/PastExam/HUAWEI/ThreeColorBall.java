package PastExam.HUAWEI;

/**
 * 华为消费者云服务三色球排序问题（0，1，2乱序排列）
 */
public class ThreeColorBall {
    /**
     * 三指针
     * @param num 未排序数组
     * @return    排序后数组
     */
    public int[] sort(int[] num) {
        int begin = 0, cur = 0, end = num.length - 1;
        while (cur <= end) {
            if (num[cur] == 0) {
                swap(num, begin, cur);
                begin++;
                cur++;
            } else if (num[cur] == 1) {
                cur++;
            } else {
                swap(num, cur, end);
                end--;
            }
        }
        return num;
    }

    private void swap(int[] num, int pos1, int pos2) {
        int tmp = num[pos1];
        num[pos1] = num[pos2];
        num[pos2] = tmp;
    }

    public static void main(String[] args) {
        ThreeColorBall threeColorBall = new ThreeColorBall();
        int[] nums = {0,2,1,2,0,1,2,0,1,2};
        int[] res = threeColorBall.sort(nums);
        for (int r : res) System.out.print(r);
    }
}
