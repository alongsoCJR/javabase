package focus.javabase.com.thread.volatileT;

public class VolatileApplication {

    // 当使用volatile时，主线程修改完内存中的flag后，对等线程会从内存中读取到flag被修改后的值，正常结束！
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread() {
            @Override
            public void run() {
                while (flag) {

                }
                System.out.println("对等线程执行完毕");
            }
        }.start();

        Thread.sleep(1000);

        flag = false;

        System.out.println("主线程执行完毕");
    }
}