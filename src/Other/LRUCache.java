package Other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: birdguan
 * @Date: 2020/6/16 19:53
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }

    public LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>();
        lruCache.put(1, "a");
        System.out.println(lruCache.keySet());
        lruCache.put(2, "b");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.get(1);
        System.out.println(lruCache.keySet());
        lruCache.put(4, "d");
        System.out.println(lruCache.keySet());
    }
}
