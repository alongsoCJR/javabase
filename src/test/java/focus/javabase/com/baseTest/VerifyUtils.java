package focus.javabase.com.baseTest;

import org.junit.Assert;

/**
 * @Author chenjianrong-lhq
 * @Description 校验是否排序
 * @Date 2020-04-05 17:45
 **/
public abstract class VerifyUtils {

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 验证从小到大排序
     * @Date 2019-07-03 23:31
     * @Param [arr]
     **/
    public static void verifySort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            Assert.assertTrue(arr[i] <= arr[++i]);
        }
    }


    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 验证两个数组是否相等  arr1-期望值  arr2-实际值
     * @Date 2019-07-03 23:31
     * @Param [arr]
     **/
    public static void verifyArrays(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length - 1; i++) {
            Assert.assertEquals(arr1[i], arr2[i]);
        }
    }


}