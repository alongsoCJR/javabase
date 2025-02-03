package focus.javabase.com.pattern.singleton;

/**
 * @model Singleton01
 * @description 饥汉式
 * @author Jianrong.Chen
 **/
public class Singleton01 {

    private Singleton01() {
    }

    private static Singleton01 singleton = new Singleton01();

    public static Singleton01 getInstance() {
        return singleton;
    }
}