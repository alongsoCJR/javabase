package focus.javabase.com.base;

import focus.javabase.com.basejava.numbers.IntWapper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntWapperTest {

    @Test
    public void testIntegerCache() {
        /** 将基本类型转化成包装类型,优先进入valueOf()方法从方法区常量池缓存中获取，如果没有，再new Integer()**/
        Integer num1 = 11;
        Integer num2 = 11;

        /** 将包装类型卸载为基本类型，通过调用intValue()方法获取基本类型值**/
        int numInt1 = num1;
        int numInt2 = num2;

        Assert.assertTrue(num1 == num2);
        Assert.assertTrue(numInt1 == numInt2);

        /**IntegerCache缓冲池中至少缓存了[-128,127]**/
        Integer num3 = 200;
        Integer num4 = 200;

        /** 修改VM启动参数可以改变Integer.IntegerCache.HIGH的最大缓冲值，修改参数的语句为 -XX:AutoBoxCacheMax=200**/
        Assert.assertTrue(num3 != num4);

        String str1 = new String("aa");
        String str2 = new String("aa");
        Assert.assertTrue(str1 != str2);


    }

    @Test
    public void testIntegerToString() {
        /**十进制转二进制**/
        Integer num = 127;
        System.out.println(Integer.toBinaryString(num));
        /**十进制转八进制**/
        System.out.println(Integer.toOctalString(num));
        /**十进制转十六进制**/
        System.out.println(Integer.toHexString(num));

        /**Integer默认的toString方法**/
        System.out.println(num.toString());
    }

    @Test
    public void testParseInt() {
        /**Integer类中的parseInt方法，返回十进制数值，带两个参数(String 字符串,几进制) 如果是8进制，则num=0*8^0+1*8^1+1*8^2=(0*8)**/
        /**为什么radix的最大取值为36呢？因为[0，9]+[a,z]=36个字符**/
        System.out.println((IntWapper.parseInt("110", 36)));

        /**
         * todo a0*8^0+a1*8^1+a2*8^2+...+a(n-1)*8^(n-1) 写错了
         * num=a(n-1)*8^0+a(n-2)*8^1+...+a1*8^(n-2)+a0*8^(n-1)
         *
         *
         *
         * 8进制数110 转十进制的公式
         * num=0*8^0+1*8^1+1*8^2=72
         * a0=1    loop   result=(0*8)-1=-1                     |(0*8)-a0|
         * a1=1                  ((0*8)-1)*8-1=-1*8-1=-9        |((0*8)-a0)*8-a1|
         * a2=0                  (((0*8)-1)*8-1)*8-0=-9*8=-72   |(((0*8)-a0)*8-a1)*8-a2|
         *
         * a(n-1)                                               |[(((0*8)-a0)*8-a1)*8-a2+...]*8-a(n-1)|
         **/
        /**Integer的parseInt方法默认String类型为10进制的数值**/
        Assert.assertTrue(IntWapper.parseInt("112") == 112);
    }


    @Test
    public void testIntWapper() {
        /**怎么使得编译通过,猜测这是编译器再搞鬼，看看反编译的文件
         *
         * 成功验证我的猜测：反编译的文件的确是调用valueOf()方法
         * Integer num=10; --> Integer integer = Integer.valueOf(10);
         *
         * 这就没法了 ^ ^,直接调valueOf()吧
         *
         * 同理，当包装类转int类型时，调用的是intValue()方法
         * int n=num; --> int i = integer.intValue();
         * **/
        IntWapper intWapper1 = IntWapper.valueOf(112);
        IntWapper intWapper2 = IntWapper.valueOf(112);
        /**验证缓冲池常量**/
        Assert.assertTrue(intWapper2 == intWapper1);


        /**Integer.valueOf()被重载了，还有valueOf(String)和valueOf(String,int)**/
        IntWapper strNum1 = IntWapper.valueOf("127");
        IntWapper strNum2 = IntWapper.valueOf("127");
        Assert.assertTrue(strNum1 == strNum2);

        /**二进制数1111 对应十进制数15**/
        IntWapper num1 = IntWapper.valueOf("1111", 2);
        IntWapper num2 = IntWapper.valueOf("1111", 2);

        Assert.assertTrue(num1 == num2);
    }

    @Test
    public void testIntWapperToString() {
        /**由于IntWapper包装类转基本类型时不能在编译时定位为Integer.intValue()方法，这里方便测试，做一下优化**/
        IntWapper num = IntWapper.valueOf(127);
        Integer num1 = 127;
        /**toString方法，返回十进制数**/
        Assert.assertEquals(Integer.toString(num1), IntWapper.toString(num.intValue()));

        /**与Integer方法进行比较**/
        Assert.assertEquals(Integer.toBinaryString(num1), IntWapper.toBinaryString(num.intValue()));
        Assert.assertEquals(Integer.toOctalString(num1), IntWapper.toOctalString(num.intValue()));
        Assert.assertEquals(Integer.toHexString(num1), IntWapper.toHexString(num.intValue()));

    }

    @Test
    public void testInteger() {
//        Assert.assertEquals(9646324351,Integer.parseInt("9646324351"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }


    /**参考网址：https://www.cnblogs.com/leilong/p/8624777.html**/
    @Test
    public void testOutBound() {
        /**
         * 对于取相反数越界的数值，取反后仍然是它本身？原因：数值+ 相反数 =0
         * 10000000000000000000000000000000+ 相反数的二进制=0 -> 相反数的二进制=10000000000000000000000000000000
         **/
        assertEquals(-2147483648, -(-2147483648));
        assertEquals(2147483647, -(-2147483647));
        assertEquals(Integer.MIN_VALUE, (1 << 31));

        /**Integer.MAX_VALUE + 1=Integer.MIN_VALUE,这两个公式都能够按照上式子推导**/
        assertEquals(-2147483648, Integer.MAX_VALUE + 1);

        /**Integer.MIN_VALUE - 1=Integer.MAX_VALUE,这两个公式都能够按照上式子推导**/
        assertEquals(Integer.MAX_VALUE, Integer.MIN_VALUE - 1);

        /**判断两个数值是否是同正负数**/
        assertEquals(false, ((Integer.MAX_VALUE << 31) ^ (Integer.MIN_VALUE << 31)) == 0);
        assertEquals(-1, Integer.MIN_VALUE + Integer.MAX_VALUE);
        assertEquals("11111111111111111111111111111000", Integer.toBinaryString(-8));
        assertEquals("11111111111111111111111111111001", Integer.toBinaryString(-7));
        assertEquals("11111111111111111111111111111010", Integer.toBinaryString(-6));
        assertEquals("11111111111111111111111111111011", Integer.toBinaryString(-5));
        assertEquals("11111111111111111111111111111100", Integer.toBinaryString(-4));
        assertEquals("11111111111111111111111111111101", Integer.toBinaryString(-3));
        assertEquals("11111111111111111111111111111110", Integer.toBinaryString(-2));
        assertEquals("11111111111111111111111111111111", Integer.toBinaryString(-1));
        assertEquals("0", Integer.toBinaryString(0));
        assertEquals("1", Integer.toBinaryString(1));
        assertEquals("10", Integer.toBinaryString(2));
        assertEquals("11", Integer.toBinaryString(3));
        assertEquals("100", Integer.toBinaryString(4));
        assertEquals("101", Integer.toBinaryString(5));
        assertEquals("110", Integer.toBinaryString(6));
        assertEquals("111", Integer.toBinaryString(7));
    }
}