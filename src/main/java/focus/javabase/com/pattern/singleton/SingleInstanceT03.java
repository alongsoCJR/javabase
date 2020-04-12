package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式 DCL
 * @ClassName: SingleInstanceT00
 */
public class SingleInstanceT03 {

    // 构造器私有化
    private SingleInstanceT03() {

    }

    public static volatile SingleInstanceT03 instance = null;

    public static SingleInstanceT03 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 同步代码块 DCL
            synchronized (SingleInstanceT03.class) {
                if (instance == null) {
                    instance = new SingleInstanceT03();
                }
            }
        }
        return instance;
    }
}
