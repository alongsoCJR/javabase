package focus.javabase.com.algorithm.interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author alongso.cjr
 * @Description bd
 * @Date 2021-04-09 18:53
 **/
public class ProviderConsumer {

    private int maxNum;

    public ProviderConsumer(int maxNum) {
        this.maxNum = maxNum;
    }

    private final LinkedList<Object> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition provider = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(Object object) {
        lock.lock();
        try {
            while (list.size() == maxNum) {
                provider.await();
            }
            list.add(object);
            consumer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take() {
        Object result = null;
        lock.lock();
        try {
            while (list.size() == 0) {
                consumer.await();
            }
            result = list.removeFirst();
            provider.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    public static void main(String[] args) {
        ProviderConsumer providerConsumer = new ProviderConsumer(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + "消费：" + providerConsumer.take());
                }
            }, "c-" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    providerConsumer.put(Thread.currentThread().getName() + "-" + j);
                }
            }, "p-" + i).start();
        }


    }
}