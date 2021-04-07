package focus.javabase.com.algorithm.interview;

import java.util.concurrent.Semaphore;


/**
 * @Author alongso.cjr
 * @Description hwl 打印ABC，1000个数
 * @Date 2021-04-07 11:55
 **/
public class PrintABCApplication {

    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        printABCThread(1000);
    }


    private static void printABCThread(int n) {
        new Thread(() -> {
            for (int i = 0; i < n; i += 3) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("A");
                semaphoreB.release();
            }
        }).start();


        new Thread(() -> {
            for (int i = 1; i < n; i += 3) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
                semaphoreC.release();
            }
        }).start();

        new Thread(() -> {

            for (int i = 2; i < n; i += 3) {
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("C");
                semaphoreA.release();
            }

        }).start();

    }
}
