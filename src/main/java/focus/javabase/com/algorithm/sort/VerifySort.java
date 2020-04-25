package focus.javabase.com.algorithm.sort;

/**
 * @Author chenjianrong-lhq
 * @Description 校验是否排序
 * @Date 2020-04-05 17:45
 **/
public abstract class VerifySort {

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 验证从小到大排序
     * @Date 2019-07-03 23:31
     * @Param [arr]
     **/
    public static void verifySort(int[] arr) {

        for (int i = 0; i < arr.length - 1; ) {
            assert (arr[i] <= arr[++i]);
        }
    }



}