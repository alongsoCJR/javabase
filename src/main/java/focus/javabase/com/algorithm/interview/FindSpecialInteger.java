package focus.javabase.com.algorithm.interview;


/**
 * @Author alongso.cjr
 * @Description blf 有序数组中出现次数超过30%的元素
 * @Date 2021-03-31 15:53
 **/
public class FindSpecialInteger {

    //    1,2,2,6,6,6,6,7,10
    public static int findSpecialInteger(int[] arr) {

        int count = 0;
        int num = arr[0];
        int i;
        for (i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                count++;
            } else {
                num = arr[i];
                count = 1;
            }


            if (10 * count > 3 * arr.length) {
                break;
            }

        }
        return arr[i];
    }

    // 1,2,2,6,6,6,6,7,10  参考  25%的题解
    public static int findSpecialInteger0(int[] arr) {

        int size = arr.length;
        int step = size >> 2;  //9 / 4 = 2
        for (int i = 0; i < size - step; i++) {
            if (arr[i] == arr[i + step]) {
                return arr[i];
            }
        }
        return -1;
    }
}