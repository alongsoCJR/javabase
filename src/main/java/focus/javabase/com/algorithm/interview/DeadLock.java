package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description 死锁代码
 * @Date 2020-10-14 10:17
 **/
class MyThread implements Runnable {
    private Object o1 = new Object();
    private Object o2 = new Object();
    private volatile boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            flag = false;
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "---have o1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "---have o2");
                }
            }
        } else {
            flag = true;
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "---have o2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "---have o1");
                }
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        new Thread(my, "Thread-a").start();
        new Thread(my, "Thread-b").start();
    }
}