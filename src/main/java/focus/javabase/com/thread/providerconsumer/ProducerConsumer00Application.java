package focus.javabase.com.thread.providerconsumer;

public class ProducerConsumer00Application {

    public static void main(String[] args) {
        ProducerConsumer00 queue = new ProducerConsumer00(10);
        Producer00 producer1 = new Producer00(queue);
        Producer00 producer2 = new Producer00(queue);
        Consumer00 consumer1 = new Consumer00(queue);
        Consumer00 consumer2 = new Consumer00(queue);
        new Thread(producer1, "生产者1").start();
        new Thread(producer2,"生产者2").start();
        new Thread(consumer1, "消费者1").start();
        new Thread(consumer2, "消费者2").start();
    }
}