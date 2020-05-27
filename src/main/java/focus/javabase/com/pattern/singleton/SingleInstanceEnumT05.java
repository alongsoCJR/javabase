package focus.javabase.com.pattern.singleton;

/**
 * @Author chenjianrong-lhq
 * @Description 枚举 单例模式
 * @Date 2020-05-27 10:23
 **/
public class SingleInstanceEnumT05 {

    private SingleInstanceEnumT05() {

    }

    private enum Singleton {
        INSTANCE;

        private final SingleInstanceEnumT05 instance;

        Singleton() {
            instance = new SingleInstanceEnumT05();
        }

        private SingleInstanceEnumT05 getInstance() {
            return instance;
        }
    }

    public static SingleInstanceEnumT05 getInstance() {
        System.out.println("SingleInstanceEnumT05 - 枚举方式");
        return Singleton.INSTANCE.getInstance();
    }
}