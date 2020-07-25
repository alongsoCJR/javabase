package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayT1441 {


    private static final String[] CONT_STR = new String[]{"Push", "Pop"};

    public static List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int j = 1;
        // 重构
        while (i < target.length && j <= n) {
            ret.add(CONT_STR[0]);
            if (target[i] == (j++)) {
                i++;
            } else {
                ret.add(CONT_STR[1]);
            }
        }
        return ret;
    }
}