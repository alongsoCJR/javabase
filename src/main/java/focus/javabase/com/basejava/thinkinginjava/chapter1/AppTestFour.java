package focus.javabase.com.basejava.thinkinginjava.chapter1;

/**
 * @author chenjianrong-lhq 2019年06月29日 16:01:17
 * @Description: DataOnly
 * @ClassName: AppTestFour
 */
public class AppTestFour {

    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 47;
        dataOnly.d = 100.0;
        dataOnly.B = false;

        System.out.println(dataOnly);

    }
}


class DataOnly {
    int i;
    double d;
    boolean B;

    /**
     * 如果一个对象里的成员变量（基本类型）没哟初始化，也会默认为该基本对象的默认值
     **/
    boolean a;

    @Override
    public String toString() {
        return "DataOnly{" +
                "i=" + i +
                ", d=" + d +
                ", B=" + B +
                ", a=" + a +
                '}';
    }
}
