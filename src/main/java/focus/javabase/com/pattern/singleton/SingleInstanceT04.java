package focus.javabase.com.pattern.singleton;

/**
 * @Author chenjianrong-lhq
 * @Description 静态内部类 初始化
 * @Date 2020-04-12 11:04
 **/
public class SingleInstanceT04 {
    private SingleInstanceT04() {
    }

    private static class InnerInitialClass {
        public static SingleInstanceT04 instance = new SingleInstanceT04();
    }

    // 原理：每个对象对应有一个初始化锁，初始化时线程需要获取该对象对应的初始化锁
    public static SingleInstanceT04 getInstance() {
        try {
            // 模拟多线程，使效果更明显
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return InnerInitialClass.instance;
    }
}