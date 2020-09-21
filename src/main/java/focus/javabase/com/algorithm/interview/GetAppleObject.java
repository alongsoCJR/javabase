package focus.javabase.com.algorithm.interview;

public class GetAppleObject {

    private static volatile int appleCount = 9;

    public static void main(String[] args) {
        Object obj = new Object();
        MonkeyOne monkeyOne = new MonkeyOne();
        MonkeyTwo monkeyTwo = new MonkeyTwo();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (obj) {
                    if (appleCount >= 2) {
                        monkeyOne.getTwoApple();
                        System.out.println(Thread.currentThread().getName() + "拿到两个苹果，剩余苹果数：" + appleCount);
                    } else {
                        break;
                    }
                }
            }
        }, "猴子一");

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (obj) {
                    if (appleCount >= 3) {
                        monkeyTwo.getThreeApple();
                        System.out.println(Thread.currentThread().getName() + "拿到三个苹果，剩余苹果数：" + appleCount);
                    } else {
                        break;
                    }
                }
            }
        }, "猴子二");


        t1.start();
        t2.start();
    }

    static class MonkeyOne {
        public void getTwoApple() {
            appleCount -= 2;
        }
    }

    static class MonkeyTwo {
        public void getThreeApple() {
            appleCount -= 3;
        }
    }
}