package focus.javabase.com.pattern.singleton;

/**
 * @author chenjianrong-lhq 2020年02月20日 11:18:10
 * @Description: 单例模式 饿汉式
 * @ClassName: SingleInstanceT00
 */
public class SingleInstanceT00 {

    // 构造器私有化
    private SingleInstanceT00() {

    }

    public static SingleInstanceT00 instance = new SingleInstanceT00();

    public static SingleInstanceT00 getInstance(){
        return instance;
    }
}
