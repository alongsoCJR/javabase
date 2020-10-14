package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjianrong-lhq
 * @Description 有序数组求交集
 * @Date 2020-10-14 10:14
 **/
public class RetainTwoArray {

    public static void main(String[] args) {
        List list = retain(new int[]{1, 2, 3}, new int[]{2, 3, 4});
    }

    public static List<Integer> retain(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && (j < b.length)) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;
    }

}