package focus.javabase.com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author chenjianrong-lhq
 * @Description 单例模式
 * @Date 2020-09-11 22:41
 **/
public class SingletonInstance {

    private SingletonInstance() {
    }

    private static volatile SingletonInstance instance = null;

    public static SingletonInstance getInstance() {
        if (instance == null) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonInstance.class) {
                if (instance == null) {
                    instance = new SingletonInstance();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonInstance instance = SingletonInstance.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}