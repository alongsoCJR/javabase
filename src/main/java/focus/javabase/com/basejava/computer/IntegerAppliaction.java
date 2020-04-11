package focus.javabase.com.computer;

/**
 * @author chenjianrong-lhq 2019年08月27日 08:11:04
 * @Description:
 * @ClassName: IntegerAppliaction
 */
public class IntegerAppliaction {


    public static void main(String[] args) {
        int intNum = 500 * 600 * 100 * 200;
        System.out.println("intNum十进制：" + intNum);
        System.out.println("intNum二进制：" + Integer.toBinaryString(intNum));
        System.out.println("intNum八进制：" + Integer.toOctalString(intNum));
        System.out.println("intNum十六进制：" + Integer.toHexString(intNum));

        /** todo 注意1 在java程序中'^' 表示异或，不能表示乘方的意思**/
        int a = 2 ^ 10 + 2 ^ 11 + 2 ^ 12 + 2 ^ 13 + 2 ^ 15 + 2 ^ 21 + 2 ^ 23 + 2 ^ 24 + 2 ^ 26 + 2 ^ 29 + 2 ^ 30;

        /** todo 注意2 在Java运算优先级中，'+' 的优先级大于 '<<' 如书上所说，在不了解优先级的情况下，最好先带上括号**/
        int b = (2 << 9) + (2 << 10) + (2 << 11) + (2 << 12) + (2 << 14) + (2 << 20) + (2 << 22) + (2 << 23) + (2 << 25) + (2 << 28) + (2 << 29);
        System.out.println(a);
        System.out.println(b);

        System.out.println("-------------------------------------------------");

        /** todo 注意3 在做系列加减乘除运算时，都有可能导致越界溢出，得到意想不到的结果，比如下面转化之前的运算**/
        long intTolongNum = 500 * 600 * 100 * 200;
        System.out.println("intTolongNum十进制：" + intTolongNum);
        System.out.println("intTolongNum二进制：" + Long.toBinaryString(intTolongNum));
        System.out.println("intTolongNum八进制：" + Long.toOctalString(intTolongNum));
        System.out.println("intTolongNum十六进制：" + Long.toHexString(intTolongNum));

        System.out.println("-------------------------------------------------");

        /** todo 注意4 int与long类型相乘，得到的结果就是long类型的，所以不会产生越界**/
        long longNum = 500 * 600 * 100 * 200L;
        System.out.println("longNum十进制：" + longNum);
        System.out.println("longNum二进制：" + Long.toBinaryString(longNum));
        System.out.println("longNum八进制：" + Long.toOctalString(longNum));
        System.out.println("longNum十六进制：" + Long.toHexString(longNum));

        /** todo 注意5 2 << 31 默认为int类型，越界后为0**/
        long c = (2 << 9) + (2 << 10) + (2 << 11) + (2 << 12) + (2 << 14) + (2 << 20) + (2 << 22) + (2 << 23) + (2 << 25) + (2 << 28) + (2 << 29) + (2 << 31);
        System.out.println(c);
        /** 2的32次方**/
        long intMax = 4294967296L;

        /** todo 注意6 二进制转十进制 应该将其中的一个因子置为long类型**/
        long d = (2 << 9) + (2 << 10) + (2 << 11) + (2 << 12) + (2 << 14) + (2 << 20) + (2 << 22) + (2 << 23) + (2 << 25) + (2 << 28) + (2 << 29) + intMax;
        System.out.println(d);
    }
}
