package focus.javabase.com.pattern.singleton;

/**
 * @author Jianrong.Chen
 * @model Singleton02
 * @description 懒汉式（不安全）
 **/
public class Singleton02 {

    private Singleton02() {
    }

    private static Singleton02 singleton = null;

    public static Singleton02 getInstance() {
        if (singleton == null) {
            singleton = new Singleton02();
        }
        return singleton;
    }
}