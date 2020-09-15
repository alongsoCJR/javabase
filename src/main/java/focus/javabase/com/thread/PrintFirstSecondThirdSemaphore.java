package focus.javabase.com.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenjianrong-lhq
 * @Description 为什么使用ReentrantLock 得不到期望的答案？
 * @Date 2020-09-13 17:36
 **/
public class PrintFirstSecondThirdSemaphore {

    private static final Semaphore s = new Semaphore(1, true);

    public PrintFirstSecondThirdSemaphore() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        s.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s.release();
    }

    public static void main(String[] args) throws InterruptedException {

        PrintFirstSecondThirdSemaphore foo = new PrintFirstSecondThirdSemaphore();

        int nums[] = new int[]{1, 2, 3, 3, 2, 1, 1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                new Thread(() -> {
                    try {
                        foo.first(() -> {
                            System.out.print("first");
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (nums[i] == 2) {
                new Thread(() -> {
                    try {
                        foo.second(() -> {
                            System.out.print("second");
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (nums[i] == 3) {
                new Thread(() -> {
                    try {
                        foo.third(() -> {
                            System.out.print("third");
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            Thread.sleep(1);
        }
        System.out.println();
    }
}