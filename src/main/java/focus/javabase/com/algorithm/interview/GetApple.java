package focus.javabase.com.algorithm.interview;

//评测题目: 无//评测题目:
//共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，
//一个猴子每次拿3个苹果，如果剩余的苹果不够猴子每次拿的数量，
//则2只猴子停止拿苹果，请用java多线程模拟上面的描述，直接在平台页面编写代码，时间30分钟左右
//请用面向对象的方式进行编写


import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author chenjianrong-lhq
 * @Description 阿里面试题
 * @Date 2020-09-21 09:01
 **/
public class GetApple {

    private static volatile int appleCount = 10000;
    private static volatile AtomicInteger atc = new AtomicInteger(0);

    public static void main(String[] args) {
        Object obj = new Object();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (obj) {
                    if (appleCount >= 3) {
                        appleCount -= 3;
                        System.out.println(Thread.currentThread().getName() + "拿到三个苹果，剩余苹果数：" + appleCount);
                    } else {
                        break;
                    }
                }
            }
        }, "猴子一");

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (obj) {
                    if (appleCount >= 2) {
                        appleCount -= 2;
                        System.out.println(Thread.currentThread().getName() + "拿到两个苹果，剩余苹果数：" + appleCount);
                    } else {
                        break;
                    }
                }
            }
        }, "猴子二");


        t1.start();
        t2.start();


    }
}