package focus.javabase.com.thread.volatileT;

public class T02_CacheLinePadding {

    // 不对齐的结果耗时：227ms，对齐的结果耗时：79ms
    private static class Padding {
        volatile long p0, p1, p2, p3, p4, p5, p6;
    }

    private static class T extends Padding {
        volatile long x = 0L;
    }


    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000L; i++) {
                    arr[0].x = i;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000L; i++) {
                    arr[1].x = i;
                }
            }
        });
        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}