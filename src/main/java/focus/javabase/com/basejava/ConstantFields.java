package focus.javabase.com.base;

import java.util.Date;

/**
 * @author chenjianrong-lhq 2019年07月11日 09:10:58
 * @Description: 测试工具类
 * @ClassName: ConstantFields
 */
public class ConstantFields {

    /**
     * 使用过期的方法，并且传递错误的参数，static变量在字节码加载进内存的时候会初始化报错
     **/
//    public static final Date submitTime = new Date("201908");

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
