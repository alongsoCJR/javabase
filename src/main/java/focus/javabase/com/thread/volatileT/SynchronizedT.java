package focus.javabase.com.thread.volatileT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SynchronizedT {

    volatile List list = new ArrayList();

    private void add(Object object) {
        list.add(object);
    }

    private int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedT t = new SynchronizedT();

//        final Object obj = new Object();
//        new Thread(() -> {
//
//            synchronized (obj){
//
//            }
//            for (int i = 0; i < 10; i++) {
//                System.out.println("添加元素" + i);
//                t.add(new Object());
////                try {
////                    TimeUnit.MILLISECONDS.sleep(500);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                if (t.size() == 5) {
//                    break;
//                }
//            }
//            System.out.println("线程2结束");
//        }).start();


        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程2启动");
                if (t.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2结束");
                lock.notify();
            }
        }).start();


        TimeUnit.MILLISECONDS.sleep(1000);


        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("添加元素" + i);
                    t.add(new Object());
                    if (i == 5) {
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }).start();


    }
}