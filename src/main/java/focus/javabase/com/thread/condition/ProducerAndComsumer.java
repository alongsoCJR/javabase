package focus.javabase.com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndComsumer {

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    private static final int CAPACITY = 10;
    private Object[] objects = new Object[CAPACITY];

    int count = 0, putPonit = 0, takePoint = 0;

    public void put(Object obj) throws InterruptedException {
        lock.lock();
        try {
            // 满了，需要阻塞
            while (count == CAPACITY) {
                notFull.await();
            }
            objects[putPonit] = obj;
            if (++putPonit == CAPACITY) {
                //
                putPonit = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 空了，需要阻塞
            while (count == 0) {
                notEmpty.await();
            }
            Object result = objects[takePoint];
            //
            if (++takePoint == CAPACITY) {
                //
                takePoint = 0;
            }
            count--;
            notFull.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ProducerAndComsumer boundedBuffer = new ProducerAndComsumer();
        new Thread(new Producer1(boundedBuffer)).start();
        new Thread(new Consumer1(boundedBuffer)).start();
        new Thread(new Consumer1(boundedBuffer)).start();
    }


}

class Consumer1 implements Runnable {

    private ProducerAndComsumer boundedBuffer;

    public Consumer1(ProducerAndComsumer boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + boundedBuffer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer1 implements Runnable {
    private ProducerAndComsumer boundedBuffer;

    public Producer1(ProducerAndComsumer boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            try {
                Task1 task1 = new Task1(i);
                boundedBuffer.put(task1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task1 {
    private int i;

    public Task1(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return i + "";
    }
}


