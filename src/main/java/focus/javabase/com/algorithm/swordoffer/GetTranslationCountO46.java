package focus.javabase.com.algorithm.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jianrong.Chen
 * @Description 把数字翻译成字符串
 * @Date 2021/1/12 10:34 AM
 */
public class GetTranslationCountO46 {

    // 12258
    // if 只有一位数，返回1  比如f(8)=1
    // if 两位数 判断 11<=ab<=25 f(ab...)=f(a)*f(b...)+f(ab)*f(...)
    // f(12258)=f(1)f(2258)+f(12)f(258)=5
    // f(2258)=f(2)f(258)+f(22)f(58)=3
    // f(258)=f(2)f(58)+f(25)f(8)=2
    // f(58)=f(5)f(8)=1
    // f(25)=1,f(22)=1
    // f(2)=1,f(5)=1,f(8)=1

    public static int getTranslationCount(int number) {
        if (number < 0) {
            return -1;
        }
        return getTranslationCountFromString(number + "");
    }

    // 递归
    private static int getTranslationCountFromString(String number) {
        if (number.length() == 0 || number.length() == 1) {
            return 1;
        }
        String front2 = number.substring(0, 2);
        int num = Integer.valueOf(front2);
        if (num >= 11 && num <= 25) {
            int count1 = getTranslationCountFromString(number.substring(1));
            int count2 = getTranslationCountFromString(number.substring(2));
            return count1 + count2;
        } else {
            return 1;
        }
    }


    //迭代 12218
    public static int getTranslationCount2(int number) {
        if (number < 0) {
            return -1;
        }
        String numberStr = String.valueOf(number);
        Map<String, Integer> resultMap = new HashMap<>();
//        resultMap.put(numberStr.substring(numberStr.length() - 1), 1); // 8=1
        for (int i = numberStr.length() - 2; i >= 0; i--) {
            String subString = numberStr.substring(i);
            String front = numberStr.substring(i, i + 2);
            if (Integer.valueOf(front) >= 11 && Integer.valueOf(front) <= 25) {
                int count = resultMap.getOrDefault(numberStr.substring(i + 1), 1)
                        + resultMap.getOrDefault(numberStr.substring(i + 2), 1);
                resultMap.put(subString, count);
            } else {
                resultMap.put(subString, 1);
            }
        }
        return resultMap.get(numberStr);
    }

}
