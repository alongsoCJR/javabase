package focus.javabase.com.algorithm.second;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache1 {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private Integer capacity;

    public LRUCache1(int capacity) {
        map = new HashMap<>(capacity);
        queue = new LinkedList<>();
        capacity = capacity;
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (result == null) {
            return -1;
        }
        //  要去维护queue里的数据
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
        // 要去维护map和queue里的数据

    }
}