package focus.javabase.com.algorithm.interview2;

import java.util.concurrent.Semaphore;

public class ABThreadPrint {


    public static void main(String[] args) {

        // 双线程打印1-1000之间的奇数和偶数
        printThreadNum(1000);
    }

    private static void printThreadNum(int n) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);

        new Thread(() -> {
            for (int i = 1; i <= n; i += 2) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i);
                semaphoreB.release();
            }
        }).start();


        new Thread(() -> {
            for (int i = 2; i <= n; i += 2) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i);
                semaphoreA.release();
            }
        }).start();

    }
}