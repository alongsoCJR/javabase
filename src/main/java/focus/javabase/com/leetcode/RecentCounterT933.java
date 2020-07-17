package focus.javabase.com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//Write a class RecentCounter to count recent requests.
//
// It has only one method: ping(int t), where t represents some time in millisec
//onds.
//
// Return the number of pings that have been made from 3000 milliseconds ago unt
//il now.
//
// Any ping with time in [t - 3000, t] will count, including the current ping.
//
// It is guaranteed that every call to ping uses a strictly larger value of t th
//an before.
//
//
//
// Example 1:
//
//
//Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1
//],[100],[3001],[3002]]
//Output: [null,1,2,3,3]
//
//
//
// Note:
//
//
// Each test case will have at most 10000 calls to ping.
// Each test case will call ping with strictly increasing values of t.
// Each call to ping will have 1 <= t <= 10^9.
//
//
//
//
// Related Topics 队列


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

    // 参考 滑动窗口
    class RecentCounter {

        private final int MAX_LENGTH = 3001;
        public int[] queue;
        private int front;
        private int rear;

        public RecentCounter() {
            this.queue = new int[MAX_LENGTH];
            this.front = 0;
            this.rear = 0;
        }

        public int ping(int t) {
            while (rear > front && t - queue[front % MAX_LENGTH] > 3000) {
                front++;
            }
            queue[rear++ % MAX_LENGTH] = t;
            return rear - front;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecentCounterT933 t933 = new RecentCounterT933();
        RecentCounter rc = t933.new RecentCounter();
        while (true) {
            if (scanner.hasNextInt()) {
                int t = scanner.nextInt();
                if (t == -1) {
                    rc = t933.new RecentCounter();
                }
                System.out.println(rc.ping(t));
            }
        }
    }
}