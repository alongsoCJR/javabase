package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<String> permutation(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || "".equals(str)) {
            return result;
        }
        getPermutation(str, result);
        return result;
    }

    // abc
    // ab ba
    // abc cba acb
    // abcd dbca adcb abdc
    //
    // bac cba
    private static void getPermutation(String str, List<String> result) {
        if (str.length() == 1) {
            result.add(str);
            return;
        }

        char start = str.charAt(0);
        List<String> subList = new ArrayList<>();
        getPermutation(str.substring(1), subList);

        for (String item : subList) {
            // bc cb
            result.add(start + item);
            for (int i = 0; i < item.length(); i++) {
                String prev = item.substring(0, i);
                String late = item.substring(i + 1);
                char a = item.charAt(i);
                result.add(a + prev + start + late);
            }
        }
    }


    // abc
    // ab ba
    // abc cba acb bac cab bca
    // abcd dbca adcb abdc

    // 涉及到多次的重复计算，效率并没有方法一高
    public static List<String> permutation0(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || "".equals(str)) {
            return result;
        }
        if (str.length() == 1) {
            result.add(str);
            return result;
        }
        char c = str.charAt(str.length() - 1);
        List<String> list = permutation(str.substring(0, str.length() - 1));
        for (int i = 0; i < str.length(); i++) {

        }

        return result;
    }
}
