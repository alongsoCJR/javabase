package focus.javabase.com.algorithm;

import focus.javabase.com.algorithm.sort.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayUtilsTest {

    int srcArr[];

    int arr[];


    @Before
    @Test
    public void testSetUp() {
//        srcArr = new int[]{100, 46, 72, 12, 8, 9, 22, 12, 13, 89, 10, 70};
        srcArr = new int[]{4, 2, 9, 8, 10, 46, 72, 12, 8};
//        srcArr = new int[]{12, 9, 10, 15, 18};

        arr = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void testBubbleSort() {
        ArrayUtils.bubbleSort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testMaoPaoSort() {
        ArrayUtils.maoPaoSort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testSelectSort() {
        ArrayUtils.selectSort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testInsertSort() {
        ArrayUtils.insertSort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testQuickSort() {
        ArrayUtils.quickSort(srcArr);
        verifySort(srcArr);

    }

    @Test
    public void testMergeSort() {
        ArrayUtils.mergeSort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testReverse() {
        ArrayUtils.reverse(srcArr);
        verifyDestArr(srcArr, new int[]{70, 10, 89, 22, 12, 72, 46, 100});
    }

    @Test
    public void testBinarySearch() {
        ArrayUtils.bubbleSort(srcArr);
        int index = ArrayUtils.binarySearch(srcArr, 100);
        Assert.assertEquals(7, index);
        int index2 = ArrayUtils.binarySearch(srcArr, 12);
        Assert.assertEquals(1, index2);
        int index3 = ArrayUtils.binarySearch(srcArr, 99);
        Assert.assertEquals(-(srcArr.length), index3);
    }


    @Test
    public void testCopyOf() {
        int[] destArr = ArrayUtils.copyOf(srcArr, 4);
        verifyDestArr(destArr, new int[]{100, 46, 72, 12});
        int[] destArr1 = ArrayUtils.copyOf(srcArr, 20);
        verifyDestArr(destArr1, srcArr);
        try {
            ArrayUtils.copyOf(srcArr, -2);
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("未捕获错误参数异常！");
    }


    @Test
    public void testPrint() {
        ArrayUtils.print(srcArr);
    }

    @Test
    public void testIndexOfAndLastIndexOf() {
        int index = ArrayUtils.indexOf(srcArr, 100);
        Assert.assertEquals(0, index);
        int index2 = ArrayUtils.lastIndexOf(srcArr, 100);
        Assert.assertEquals(7, index2);
    }


    @Test
    public void testMaxAndMin() {
        int max = ArrayUtils.getMax(srcArr);
        Assert.assertEquals(100, max);

        int min = ArrayUtils.getMin(srcArr);
        Assert.assertEquals(10, min);
    }

    @Test
    public void testAsList() {
        List<Integer> arrList = ArrayUtils.asList(srcArr);
        Assert.assertEquals(8, arrList.size());
        Assert.assertEquals(new Integer(100), arrList.get(0));
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 验证从小到大排序
     * @Date 2019-07-03 23:31
     * @Param [arr]
     **/
    private void verifySort(int[] arr) {
        /** 你真的懂了i++吗？你可能都没有懂arr[i++]与arr[++i]的区别**/
        for (int i = 0; i < arr.length - 1; ) {
            Assert.assertTrue(arr[i] <= arr[++i]);
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 验证反向排序
     * @Date 2019-07-03 23:31
     * @Param [srcArr]
     **/
    private void verifyDestArr(int[] srcArr, int[] destArr) {
        for (int i = 0; i < srcArr.length; i++) {
            Assert.assertEquals(srcArr[i], destArr[i]);
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 二分排序，性能较差，一般不使用
     * @Date 2019-07-25 20:39
     * @Param []
     **/
    @Test
    public void testArraySort() {
        ArrayUtils.binarySort(srcArr);
        verifySort(srcArr);
    }

    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 泛型消除, 对于集合类来说，泛型会带来类型消除的问题，隐藏一些重大生产事故
     * @Date 2019-07-25 20:39
     * @Param
     **/
    @Test
    public void testGenerics() {
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        Assert.assertTrue(intList.getClass() == strList.getClass());
        /**lamda表达式**/
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, (Integer i1, Integer i2) -> i1 % 2 - i2 % 2);
    }
}