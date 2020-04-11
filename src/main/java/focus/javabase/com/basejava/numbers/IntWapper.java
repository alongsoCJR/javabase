package focus.javabase.com.basejava.numbers;


import java.lang.annotation.Native;

/**
 * @author chenjianrong-lhq 2019年07月15日 11:53:45
 * @Description: int包装类类型
 * @ClassName: IntWapper
 */
public class IntWapper {

    @Native
    public static final int MIN_VALUE = 0x80000000;

    @Native
    public static final int MAX_VALUE = 0x7fffffff;

    public int value;

    /**
     * All possible chars for representing a number as a String
     */
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public IntWapper(int val) {
        this.value = val;
    }

    public static IntWapper valueOf(int i) {
        if (i >= IntWapper.IntegerCache.low && i <= IntWapper.IntegerCache.high) {
            return IntWapper.IntegerCache.cache[i + (-IntWapper.IntegerCache.low)];
        }
        return new IntWapper(i);
    }

    public static IntWapper valueOf(String s) {
        return IntWapper.valueOf(parseInt(s, 10));
    }

    public static IntWapper valueOf(String s, int radix) {
        return IntWapper.valueOf(parseInt(s, radix));
    }

    public static String toBinaryString(int i) {
        return toUnsignedString0(i, 1);
    }


    public static String toOctalString(int i) {
        return toUnsignedString0(i, 3);

    }

    public static String toHexString(int i) {
        return toUnsignedString0(i, 4);

    }

    public static String toString(int s) {
        return s + "";
    }

    private static String toUnsignedString0(int val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];

        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf);
    }

    public int intValue() {
        return this.value;
    }


    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = IntWapper.digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }

    /**
     * 静态类部类,问题，静态内部类在什么时候初始化？
     **/
    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final IntWapper cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("focus.javabase.com.base.IntWapper.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
                } catch (NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new IntWapper[(high - low) + 1];
            int j = low;
            for (int k = 0; k < cache.length; k++) {
                cache[k] = new IntWapper(j++);
            }

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntWapper.IntegerCache.high >= 127;
        }

        private IntegerCache() {
        }
    }

    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s, 10);
    }


    public static int parseInt(String s, int radix) throws NumberFormatException {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw NumberFormatException.forInputString(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw NumberFormatException.forInputString(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw NumberFormatException.forInputString(s);
                }
                if (result < multmin) {
                    throw NumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw NumberFormatException.forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
    }
}
