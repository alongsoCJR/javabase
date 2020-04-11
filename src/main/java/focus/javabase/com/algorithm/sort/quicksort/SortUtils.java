package focus.javabase.com.quicksort;

/**
 * @author chenjianrong-lhq 2019年07月08日 15:45:07
 * @Description: sort工具类
 * @ClassName: SortUtils
 */
public class SortUtils {
    private SortUtils() {

    }

    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean less(int m, int n) {
        return m < n;
    }
}
