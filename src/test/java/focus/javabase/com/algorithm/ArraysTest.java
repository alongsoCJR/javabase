package focus.javabase.com.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArraysTest {

    int srcArr[];

    List<Integer> srcList = new ArrayList<>();

    Integer srcIntegerArr[];

    @Before
    @Test
    public void testSetUp() {
        srcArr = new int[]{100, 46, 72, 12, 22, 89, 10, 70};
        for (int num : srcArr) {
            srcList.add(num);
        }
        srcIntegerArr = new Integer[srcArr.length];
        for (int i = 0; i < srcArr.length; i++) {
            srcIntegerArr[i] = srcArr[i];
        }
    }

    @Test
    public void testMergeSort() {
        Arrays.sort(srcArr);
        verifySort(srcArr);
    }

    @Test
    public void testReverse() {
        /** Arrays没有自带reverse方法，这里学习Conllections工具类对List集合的反转**/
        Collections.reverse(srcList);
        Integer arr[] = new Integer[srcArr.length];
        /** List集合转为数组**/
        srcList.toArray(arr);
        verifyDestArr(arr, new Integer[]{70, 10, 89, 22, 12, 72, 46, 100});
    }


    @Test
    public void testBinarySearch() {
        Arrays.sort(srcArr);
        int index = Arrays.binarySearch(srcArr, 100);
        Assert.assertEquals(7, index);
        int index2 = Arrays.binarySearch(srcArr, 12);
        Assert.assertEquals(1, index2);
        /** jdk1.8源码中，如果不存在，不再返回-1,而是返回-(arr.length)**/
        int index3 = Arrays.binarySearch(srcArr, 99);
        Assert.assertEquals(-(srcArr.length), index3);
    }


    @Test
    public void testCopyOf() {
        /** 源码中，copyOf是native方法，由System.arraycopy()实现的**/
        int[] destArr = Arrays.copyOf(srcArr, 4);
        verifyDestArr(destArr, new int[]{100, 46, 72, 12});
        /** 源码中，竟然不会抛出异常，源码对长度进行了处理【Math.min(original.length, newLength)】**/
        Arrays.copyOf(srcArr, 20);
        try {
            /** 在定义数时，如果长度<0,则会抛出NegativeArraySizeException类型的异常**/
            Arrays.copyOf(srcArr, -1);
        } catch (NegativeArraySizeException e) {
            return;
        }
        Assert.fail("未捕获错误异常！");
    }


    @Test
    public void testPrint() {
        /**打印数组，用[,]将元素隔开**/
        System.out.println(Arrays.toString(srcArr));
    }

    @Test
    public void testIndexOfAndLastIndexOf() {
        int index = srcList.indexOf(100);
        Assert.assertEquals(0, index);
        int index2 = srcList.lastIndexOf(100);
        /** 为什么这里返回的是0呢，额额**/
        Assert.assertEquals(0, index2);
    }


    @Test
    public void testMaxAndMin() {
        /**学习Conllections工具类对List集合获取最大值最小值，List的元素必须实现Comparable接口**/
        int max = Collections.max(srcList);
        Assert.assertEquals(100, max);

        int min = Collections.min(srcList);
        Assert.assertEquals(10, min);
    }

    @Test
    public void testAsList() {
        /**Arrays.asList()返回的是Arrays中定义的内部类ArrayList,该类方法有限，不支持add和remove等方法，用的时候需要注意**/
        List<Integer> arrList = Arrays.asList(srcIntegerArr);
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

    private void verifyDestArr(Integer[] srcArr, Integer[] destArr) {
        for (int i = 0; i < srcArr.length; i++) {
            Assert.assertEquals(srcArr[i], destArr[i]);
        }
    }

}