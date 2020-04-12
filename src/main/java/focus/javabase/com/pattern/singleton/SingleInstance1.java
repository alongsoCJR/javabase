package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式，线程不安全
 * @ClassName: SingleInstance
 */
public class SingleInstance1 {

    // 构造器私有化
    private SingleInstance1() {

    }

    public static SingleInstance1 instance = null;

    public static SingleInstance1 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleInstance1();
        }
        return instance;
    }
}
