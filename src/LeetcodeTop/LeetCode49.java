package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 8:53
 */

import com.sun.org.apache.xerces.internal.xs.StringList;
import jdk.nashorn.internal.objects.NativeObject;

import java.util.*;

/**
 * LeetCode49 字母异位词分组 MEDIUM
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode49 {
    /**
     * 方法一： 排序数组分类（哈希表）
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSolution1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    /**
     * 方法二：按计数分类（哈希表）
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSolution2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s :strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c-'a']++;
            String key = Arrays.toString(count);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
