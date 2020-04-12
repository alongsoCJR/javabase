package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式
 * @ClassName: SingleInstanceT00
 */
public class SingleInstanceT02 {

    // 构造器私有化
    private SingleInstanceT02() {

    }

    public static SingleInstanceT02 instance = null;

    // 同步方法作用域太大，性能低
    public static synchronized SingleInstanceT02 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleInstanceT02();
        }
        return instance;
    }
}
