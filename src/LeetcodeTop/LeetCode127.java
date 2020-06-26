package LeetcodeTop;

/**
 * @Author: birdguan
 * @Date: 2020/6/22 19:51
 */

import javafx.util.Pair;

import java.lang.ref.SoftReference;
import java.util.*;

/**
 * LeetCode127 单词接龙 MEDIUM
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode127 {

    /**
     * 广度优先搜索bfs
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  单词表
     * @return  最短转换序列长度
     */
    public int ladderLengthSolution1(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < len; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                }
        );

        // Query for BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // 访问数组记录，防止出现死环
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) return level+1;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }

            }
        }
        return 0;
    }

    /* --------------------------------------------------------- */

    private int len;
    private Map<String, List<String>> queryMap;

    /**
     * 双向广度优先搜索
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  单词表
     * @return  最短转换序列长度
     */
    public int ladderLengthSolution2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        len = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                List<String>transformations = queryMap.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                queryMap.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> queueBegin = new LinkedList<>();
        Queue<Pair<String, Integer>> queueEnd = new LinkedList<>();
        queueBegin.offer(new Pair<>(beginWord, 1));
        queueEnd.offer(new Pair<>(endWord, 1));

        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            int ans = visitWordNode(queueBegin, visitedBegin, visitedEnd);
            if (ans > -1) return ans;
            ans = visitWordNode(queueEnd, visitedEnd, visitedBegin);
            if (ans > -1) return ans;
        }
        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue,
                              Map<String, Integer> visited,
                              Map<String, Integer> otherVisited) {
        Pair<String, Integer> node = queue.poll();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < len; i++) {
            String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
            for (String queriedWord : queryMap.getOrDefault(newWord, new ArrayList<>())) {
                if (otherVisited.containsKey(queriedWord)) {
                    return level + otherVisited.get(queriedWord);
                }

                if (!visited.containsKey(queriedWord)) {
                    visited.put(queriedWord, level + 1);
                    queue.offer(new Pair(queriedWord, level + 1));
                }
            }
        }
        return -1;
    }
}
