package focus.javabase.com.thread;


/**
 * @Author chenjianrong-lhq
 * @Description 两个线程同时异步执行，其中一个线程只会打印A，一个只会打印B，要求控制台输出ABAB...ABAB
 * @Date 2020-09-11 22:42
 **/
public class PrintABThread {

    public static void main(String[] args) {

        final Object object = new Object();

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 50; i++) {
                    System.out.print("B");
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();


        Thread t1 = new Thread(() -> {
            synchronized (object) {
                for (int i = 0; i < 50; i++) {
                    System.out.print("A");
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        });
        t1.start();
    }


}


class AThread implements Runnable {

    @Override
    public void run() {
        System.out.println("A");
    }
}

class BThread implements Runnable {

    @Override
    public void run() {
        System.out.println("B");
    }
}