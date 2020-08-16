package LeetcodeTop;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LeetCode341 扁平化嵌套列表迭代器 MEDIUM
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LeetCode341 implements Iterator<Integer> {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    public List<Integer> list;
    private int index;

    public LeetCode341(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    private static List<Integer> integerIterator(List<NestedInteger> nestedIntegerList) {
        ArrayList<Integer> list = new ArrayList<>();
        for (NestedInteger tmp : nestedIntegerList) {
            if (tmp.isInteger()) list.add(tmp.getInteger());
            else list.addAll(integerIterator(tmp.getList()));
        }
        return list;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < list.size();
    }

    @Override
    public Integer next() {
        if (this.hasNext()) return list.get(++index);
        return null;
    }

}
