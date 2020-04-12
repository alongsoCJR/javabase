package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 懒汉式 DCL
 * @ClassName: SingleInstance
 */
public class SingleInstance3 {

    // 构造器私有化
    private SingleInstance3() {

    }

    public static volatile SingleInstance3 instance = null;

    public static SingleInstance3 getInstance() {
        if (instance == null) {
            try {
                // 模拟多线程，使效果更明显
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 同步代码块 DCL
            synchronized (SingleInstance3.class) {
                if (instance == null) {
                    instance = new SingleInstance3();
                }
            }
        }
        return instance;
    }

}
