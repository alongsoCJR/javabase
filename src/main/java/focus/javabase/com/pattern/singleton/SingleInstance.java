package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 饿汉式
 * @ClassName: SingleInstance
 */
public class SingleInstance {

    // 构造器私有化
    private SingleInstance() {

    }

    public static SingleInstance instance = new SingleInstance();

    public static SingleInstance getInstance(){
        return instance;
    }
}
