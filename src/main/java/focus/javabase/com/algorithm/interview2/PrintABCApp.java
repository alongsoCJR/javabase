package focus.javabase.com.algorithm.interview2;

import java.util.concurrent.Semaphore;

public class PrintABCApp {

    public static void main(String[] args) {

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
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
            for (int i = 0; i < 10; i++) {
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
            for (int i = 0; i < 10; i++) {
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