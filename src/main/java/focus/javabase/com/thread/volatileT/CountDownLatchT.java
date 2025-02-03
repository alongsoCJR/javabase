package focus.javabase.com.thread.volatileT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchT {

    volatile List list = new ArrayList();

    private void add(Object object) {
        list.add(object);
    }

    private int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchT t = new CountDownLatchT();

        CountDownLatch t1 = new CountDownLatch(1);
        CountDownLatch t2 = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("线程2启动");
            if (t.size() != 5) {
                try {
                    t2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程2结束");
            t1.countDown();
        },"t2").start();


        TimeUnit.MILLISECONDS.sleep(1000);


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("添加元素" + i);
                t.add(new Object());
                if (i == 5) {
                   t2.countDown();
                    try {
                        t1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        },"t1").start();


    }
}