package focus.javabase.com.thread.base;

public class T03_YieldJoin {
    private static class YieldThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " in  Control");
            }
        }
    }


    private static class JoinThread extends Thread {
        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("Current thread: " + t.getName());

            // checks if current thread is alive
            System.out.println("Is Alive? " + t.isAlive());
        }
    }


    public static void main(String[] args) {
        // 把当前任务放入到等待队列中，让别的线程优先执行（但有可能还是拿到当前的任务执行，比如等待队列没有任务时）
//        testYield();

        // 当前线程调用了别的线程，调用join()时让当前线程等待（堵塞），当调用线程执行完了，自己再执行。
        testJoin();

    }

    private static void testJoin() {
        Thread t = new Thread(new JoinThread());
        t.start();

        // Waits for 1000ms this thread to die.If thread is dead，execute next instruction
        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nJoining after 1000" + " mili seconds: \n");
        System.out.println("Current thread: " + t.getName());


        // Checks if this thread is alive
        System.out.println("Is alive? " + t.isAlive());

    }

    private static void testYield() {

        Thread thread = new YieldThread();
        thread.start();


        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " in  Control");
        }
    }
}