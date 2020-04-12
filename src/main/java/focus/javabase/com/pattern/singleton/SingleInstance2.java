package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式
 * @ClassName: SingleInstance
 */
public class SingleInstance2 {

    // 构造器私有化
    private SingleInstance2() {

    }

    public static SingleInstance2 instance = null;

    // 同步方法作用域太大，性能低
    public static synchronized SingleInstance2 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleInstance2();
        }
        return instance;
    }
}
