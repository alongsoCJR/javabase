package focus.javabase.com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 达到上限，不能放了
            while (count == items.length) {
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            // 唤醒拿任务线程
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        BoundedBuffer boundedBuffer = new BoundedBuffer();
        new Thread(new Producer(boundedBuffer)).start();
        new Thread(new Consumer(boundedBuffer)).start();
        new Thread(new Consumer(boundedBuffer)).start();
    }


}

class Consumer implements Runnable {

    private BoundedBuffer boundedBuffer;

    public Consumer(BoundedBuffer boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                System.out.println(boundedBuffer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private BoundedBuffer boundedBuffer;

    public Producer(BoundedBuffer boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                Task1 task1 = new Task1(i);
                boundedBuffer.put(task1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task {
    private int i;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return i + "";
    }
}