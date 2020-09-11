package focus.javabase.com.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenjianrong-lhq
 * @Description 京东机试题  按照输入的顺序 异步执行 1线程 first 2线程 second  3线程 third,要求控制台输出和输入顺序一致
 * @Date 2020-09-11 22:40
 **/
public class Print123Thread {

    public static void main(String[] args) {
        int[] inputNums = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            inputNums[i] = random.nextInt(3) + 1;
        }
        System.out.println(Arrays.toString(inputNums));
        runThreads(inputNums);
    }

    public static void runThreads(int[] orders) {
        final Foo foo = new Foo();
//        ExecutorService executor = Executors.newSingleThreadExecutor();

        ExecutorService executor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < orders.length; i++) {
            I m = orders[i] == 1 ? foo::first :
                    orders[i] == 2 ? foo::second : foo::third;
            executor.execute(new Thread(() -> m.m()));
        }
        executor.shutdown();
    }

    public static interface I {
        void m();
    }
}


class Foo {


    public void first() {
        System.out.print("first,");
    }

    public void second() {
        System.out.print("second,");
    }

    public void third() {
        System.out.print("third,");
    }
}