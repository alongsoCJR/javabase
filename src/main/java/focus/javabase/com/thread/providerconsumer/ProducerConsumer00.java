package focus.javabase.com.thread.providerconsumer;

public class ProducerConsumer00 {

    private int capacity;

    private volatile int num;

    public ProducerConsumer00(int capacity) {
        this.capacity = capacity;
        num = 0;
    }

    public synchronized void produce() {
        while (num >= capacity) {
            try {
                System.out.println("生产数量已达到上限，请消费！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++num;
        System.out.println(Thread.currentThread().getName() + "-生产元素：" + num);
        notify();
    }

    public synchronized void consume() {
        while (num <= 0) {
            try {
                System.out.println("生产数量为0，请生产！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "—消费元素：" + num);
        --num;
        notify();
    }
}