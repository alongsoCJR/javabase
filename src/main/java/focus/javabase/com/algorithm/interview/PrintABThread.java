package focus.javabase.com.algorithm.interview;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author chenjianrong-lhq
 * @Description mt机试
 * @Date 2020-09-22 09:06
 **/
public class PrintABThread {

    public static Thread aThread = null;
    public static Thread bThread = null;

    public static void main(String[] args) {


        aThread = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.print("A");
                LockSupport.unpark(bThread);
            }

        });

        bThread = new Thread(() -> {
            while (true) {
                System.out.print("B");
                LockSupport.unpark(aThread);
                LockSupport.park();
            }
        });

        aThread.start();
        bThread.start();
    }
}