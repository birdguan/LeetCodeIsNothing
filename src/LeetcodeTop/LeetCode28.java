package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/5/30 18:18
 */

/**
 * LeetCode28 实现strStr() EASY
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode28 {
    /**
     * 方法一：子串注意比较——线性时间复杂度
     * 时间复杂度：O((N-L)L)
     * 空间复杂度：O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrSolution1(String haystack, String needle) {
        int l = needle.length(), n = haystack.length();
        for (int start = 0; start <= n - l; start++) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 方法二：双指针——线性时间复杂度
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrSolution2(String haystack, String needle) {
        int l = needle.length(), n = haystack.length();
        if (l == 0) return 0;
        int pn = 0;
        while (pn < pn - l + 1) {
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) pn++;
            int currLen = 0, pl = 0;
            while (pl < l && pn < n && haystack.charAt(pn) == needle.charAt(pl)) {
                pn++;
                pl++;
                currLen++;
            }
            if (currLen == l) return pn-l;
            // pn回溯
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
