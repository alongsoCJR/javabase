package focus.javabase.com.thread;


import java.util.concurrent.locks.LockSupport;

/**
 * @Author chenjianrong-lhq
 * @Description 两个线程同时异步执行，其中一个线程只会打印ABC，一个只会打印123，要求控制台输出A1B2C3...
 * @Date 2020-09-11 22:42
 **/
public class PrintA1B2Thread {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        t2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                LockSupport.park();
                System.out.print(i);
                LockSupport.unpark(t1);
            }
        });

        t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2.start();
        t1.start();
    }


}
