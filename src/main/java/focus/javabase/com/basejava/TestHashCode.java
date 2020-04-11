package focus.javabase.com.basejava;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static java.util.Arrays.sort;

/**
 * @author chenjianrong-lhq 2019年07月10日 21:40:12
 * @Description: 十六进制转十进制
 * @ClassName: TestHashCode
 */

public class TestHashCode {

    protected static Log logger = LogFactory.getLog(TestHashCode.class);

    /**
     * Object中的toString方法 this.getClass().getName() + "@" + Integer.toHexString(this.hashCode())
     **/
    public static void main(String[] args) {

        int[] arg = new int[]{123, 12, 12};
        Object obj = new Object();
        Object obj2 = new Object();
        logger.error("aaa");

        User user = new User("Alongso");
        System.out.println(user);
        sort(args);
        System.out.println(arg);
        System.out.println(obj);
        System.out.println(obj2);
        /**不管何时运行，分配的内存地址是一样的？**/
        System.out.println(Integer.parseUnsignedInt("2626b418", 16));
        System.out.println(Integer.parseUnsignedInt("5451c3a8", 16));
        System.out.println(Integer.parseUnsignedInt("5a07e868", 16));
    }


}

class User {
    private String userName;
    private int age;

    public User(String userName) {
        /** this()方法必须置于构造器第一行**/
//        this.age = 1;
        this(userName, 0);
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
