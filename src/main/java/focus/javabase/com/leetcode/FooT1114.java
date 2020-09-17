package focus.javabase.com.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooT1114 {

    private Lock lock = null;
    private volatile int state;

    public FooT1114() {
        lock = new ReentrantLock(true);
        state = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (state != 0) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        state++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (state != 1) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        state++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (state != 2) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        state++;
    }

    public static void main(String[] args) throws InterruptedException {

        FooT1114 foo = new FooT1114();

        int nums[] = new int[]{3, 2, 1};
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
        }
        System.out.println();
    }
}