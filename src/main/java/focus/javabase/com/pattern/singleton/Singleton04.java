package focus.javabase.com.pattern.singleton;

/**
 * @author Jianrong.Chen
 * @model Singleton04
 * @description
 **/
public class Singleton04 {

    private Singleton04() {
    }

    private static volatile Singleton04 singleton = null;

    public static Singleton04 getInstance() {
        if (singleton == null) {
            synchronized (Singleton04.class) {
                if (singleton == null) {
                    singleton = new Singleton04();
                }
            }
        }
        return singleton;
    }
}