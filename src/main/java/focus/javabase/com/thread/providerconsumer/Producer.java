package focus.javabase.com.thread.providerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                blockingQueue.put(i);
                System.out.println("生产元素：" + i + ", queues：" + blockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}