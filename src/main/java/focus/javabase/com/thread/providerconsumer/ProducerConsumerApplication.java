package focus.javabase.com.thread.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerApplication {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        new Thread(producer1, "生产者1").start();
        new Thread(producer2,"生产者2").start();
        new Thread(consumer1, "消费者1").start();
        new Thread(consumer2, "消费者2").start();
    }
}