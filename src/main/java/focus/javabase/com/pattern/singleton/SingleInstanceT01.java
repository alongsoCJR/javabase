package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式，线程不安全
 * @ClassName: SingleInstanceT00
 */
public class SingleInstanceT01 {

    // 构造器私有化
    private SingleInstanceT01() {

    }

    public static SingleInstanceT01 instance = null;

    public static SingleInstanceT01 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleInstanceT01();
        }
        return instance;
    }
}
