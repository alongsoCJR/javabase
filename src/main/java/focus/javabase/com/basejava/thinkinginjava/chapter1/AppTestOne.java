package focus.javabase.com.basejava.thinkinginjava.chapter1;

/**
 * @author chenjianrong-lhq 2019年06月29日 15:15:17
 * @Description: int与char作用域的验证
 * @ClassName: AppTestOne
 */
public class AppTestOne {
    static byte aByte;
    static short aShort;
    static int aInt;
    static long aLong;
    static char aChar;
    static boolean aBoolean;
    static float aFloat;
    static double aDouble;


    public static void main(String[] args) {
        /** 局部变量必须初始化，否则编译报错**/
       /* int one;
        char c;*/
        System.out.println("aByte=" + aByte);
        System.out.println("aShort=" + aShort);
        System.out.println("aInt=" + aInt);
        System.out.println("aLong=" + aLong);
        System.out.println("aChar=" + aChar);
        System.out.println("aBoolean=" + aBoolean);
        System.out.println("aFloat=" + aFloat);
        System.out.println("aDouble=" + aDouble);

        System.out.println(Byte.MIN_VALUE + "<Byte values between>" + Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE + "<Short values between>" + Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE + "<Integer values between>" + Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE + "<Long values between>" + Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE + "<Float values between>" + Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + "<Double values between>" + Double.MAX_VALUE);
        Character c=Character.MIN_VALUE;
        System.out.println(c==aChar);
        System.out.println(c.equals(aChar));
        System.out.println(Character.MIN_VALUE +  Character.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE-1);
    }


}
