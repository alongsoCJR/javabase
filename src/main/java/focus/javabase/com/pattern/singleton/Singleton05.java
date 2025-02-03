package focus.javabase.com.pattern.singleton;

/**
 * @author Jianrong.Chen
 * @model Singleton04
 * @description
 **/
public class Singleton05 {

    private Singleton05() {
    }


    private static class InnerClass {
        private static Singleton05 singleton = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return InnerClass.singleton;
    }
}