package focus.javabase.com.thread.volatileT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportT {

    volatile List list = new ArrayList();

    private void add(Object object) {
        list.add(object);
    }

    private int size() {
        return list.size();
    }

    static Thread t1, t2;

    public static void main(String[] args) throws InterruptedException {
        LockSupportT t = new LockSupportT();
        t2 = new Thread(() -> {
            System.out.println("线程2启动");
            if (t.size() != 5) {
                LockSupport.park();
            }
            System.out.println("线程2结束");
            LockSupport.unpark(t1);
        });
        t2.start();


        TimeUnit.MILLISECONDS.sleep(1000);


        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("添加元素" + i);
                t.add(new Object());
                if (i == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });
        t1.start();


    }
}