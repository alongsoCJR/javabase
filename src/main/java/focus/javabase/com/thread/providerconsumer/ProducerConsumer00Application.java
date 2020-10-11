package focus.javabase.com.thread.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer00Application {

    public static void main(String[] args) {
        ProducerConsumer00 queue = new ProducerConsumer00(10);
        Producer00 producer = new Producer00(queue);
        Consumer00 consumer = new Consumer00(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
//        new Thread(consumer).start();
    }
}