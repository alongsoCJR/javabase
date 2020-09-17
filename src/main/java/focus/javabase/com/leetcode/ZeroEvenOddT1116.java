package focus.javabase.com.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOddT1116 {


    private int n;
    private volatile int flag = 0;

    public ZeroEvenOddT1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag != 0) {
                Thread.yield();
            }
            // 打印zero
            printNumber.accept(0);
            // 根据n的值，唤醒奇数/偶数
            if (n % 2 == 0) {
                flag = 2;
            } else {
                flag = 1;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (flag != 1) {
                Thread.yield();
            }
            // 打印奇数
            printNumber.accept(i);
            // 唤醒zero
            flag = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i < n; i += 2) {
            while (flag != 2) {
                Thread.yield();
            }
            // 打印偶数
            printNumber.accept(i);
            // 唤醒zero
            flag = 0;
        }
    }

}

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore oddSemaphore = new Semaphore(0);
    private Semaphore evenSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            // 打印zero
            printNumber.accept(0);
            // 根据n的值，唤醒奇数/偶数
            if (i % 2 == 0) {
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            // 打印偶数
            printNumber.accept(i);
            // 唤醒zero
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            // 打印奇数
            printNumber.accept(i);
            // 唤醒zero
            zeroSemaphore.release();
        }
    }
}