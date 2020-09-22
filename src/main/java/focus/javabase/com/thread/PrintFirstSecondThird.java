package focus.javabase.com.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenjianrong-lhq
 * @Description 为什么使用ReentrantLock 得不到期望的答案？因为线程虽然起来了，但是没有获取CPU时间片，所以控制不了顺序。
 * @Date 2020-09-13 18:14
 **/
public class PrintFirstSecondThird {

    private static final Lock lock = new ReentrantLock(true);

    public PrintFirstSecondThird() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintFirstSecondThird foo = new PrintFirstSecondThird();
        int[] nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums[i] = random.nextInt(3) + 1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                new Thread(() -> {
                    try {
                        foo.first(() -> {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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
            // 在这里加入睡眠之后，线程争取到时间片，就能控制lock.lock()的执行顺序了。
            TimeUnit.NANOSECONDS.sleep(1);
        }
        System.out.println();
    }
}