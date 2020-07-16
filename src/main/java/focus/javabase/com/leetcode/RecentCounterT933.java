package focus.javabase.com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounterT933 {

    private Queue<Integer> q1 = null;

    public RecentCounterT933() {
        q1 = new LinkedList();
    }

    public int ping(int t) {
        q1.offer(t);
        while (q1.peek() < (t - 3000)) {
            q1.poll();
        }
        return q1.size();
    }
}