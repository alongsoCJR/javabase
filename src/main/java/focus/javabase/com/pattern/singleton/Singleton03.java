package focus.javabase.com.pattern.singleton;

/**
 * @author Jianrong.Chen
 * @model Singleton03
 * @description
 **/
public class Singleton03 {

    private Singleton03() {
    }

    private static Singleton03 singleton = null;

    public static synchronized Singleton03 getInstance() {
        if (singleton == null) {
            singleton = new Singleton03();
        }
        return singleton;
    }
}