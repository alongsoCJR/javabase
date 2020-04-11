package focus.javabase.com.basejava.computer;

/**
 * @author chenjianrong-lhq 2019年09月17日 09:04:18
 * @Description: 浮点数测试类
 * @ClassName: FloatApplication
 */
public class FloatApplication {

    public static void main(String[] args) {
        float a = 1.0f;
        float b = 0.9f;

        float c = a - b;
        /** output:0.100000024 float类型带来的精度问题**/
        System.out.println(c);
        System.out.println(Long.MAX_VALUE);
    }
}
