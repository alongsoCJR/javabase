package focus.javabase.com.algorithm.second;

import java.util.*;

public class LRUCache extends LinkedHashMap {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return (int) getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}