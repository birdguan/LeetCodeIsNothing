package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/2 9:05
 */


import java.util.Stack;
import java.util.Vector;

/**
 * LeetCode42 接雨水 HARD
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode42 {
    /**
     * 方法一：暴力
     * 时间复杂度：O(n^2)，每个元素都需要向左向右扫描
     * 空间复杂度：O(1)
     * @param height
     * @return
     */
    public int trapSolution1(int[] height) {
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len-1; i++) {
            int maxLeft = 0, maxRight = 0;
            // Search the left part for max bar size
            for (int j = i; j >=0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // Search the right part for max bar size
            for (int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 方法二：动态规划
     * 时间复杂度：O(n)
     * 控件复杂度：O(n)
     * 算法：
     * 1.找到数组中从下标i到最左端最高的条形块高度leftMax
     * 2.找到数组中从下标i到最右端最高的条形快高度rightMax
     * 3.扫描数组height并更新答案：累加min(maxLeft[i],maxRight[i])-height[i]到ans上
     * @param height
     * @return
     */
    public int trapSolution2(int[] height) {
        if (height == null) return 0;
        int ans = 0;
        int len = height.length;
        int[] leftMaxes = new int[len], rightMaxes = new int[len];
        leftMaxes[0] =height[0];
        for (int i = 1; i < len; i++) {
            leftMaxes[i] = Math.max(height[i], leftMaxes[i-1]);
        }
        rightMaxes[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMaxes[i] = Math.max(height[i], rightMaxes[i+1]);
        }
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(leftMaxes[i], rightMaxes[i]) - height[i];
        }
        return ans;
    }

    /**
     * 方法三：栈的应用
     * 时间复杂度：O(n)
     * 控件复杂度：O(n)
     * 算法：
     * 使用栈来存储条形块的索引下标
     * 遍历数组
     *      - 当栈非空且height[current] > height[stack.peek()]
     *          意味着栈中元素可以被弹出，弹出栈顶元素top
     *          计算当前元素和栈顶元素的距离，准备进行填充操作distance = current - stack.peek() - 1
     *          找出界定高度
     *              boundedHeight = min(height[current], height[stack.peek()]) - height[top]
     *          往答案中累加积水量ans += distance * boundedHeight
     *      - 将当前索引下标入栈
     *      - 将current移动到下个位置
     * @param height
     * @return
     */
    public int trapSolution3(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(current++);
        }
        return ans;
    }

    /**
     * 方法四：使用双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param height
     * @return
     */
    public int trapSolution4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += left - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += right - rightMax;
                }
                right--;
            }
        }
        return ans;
    }
}






