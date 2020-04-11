package focus.javabase.com.algorithm;

import focus.javabase.com.algorithm.sort.MergeSort;
import focus.javabase.com.algorithm.sort.QuickSort;
import focus.javabase.com.algorithm.sort.VerifySort;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

    int srcArr[];

    int arr[];


    @Before
    @Test
    public void testSetUp() {
        srcArr = new int[]{4, 2, 9, 8, 10, 46, 72, 12, 8};
        arr = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void testMergeSort() {
        MergeSort.mergeSort(srcArr, 0, srcArr.length - 1);
        VerifySort.verifySort(srcArr);
    }

    @Test
    public void testQuickSort() {
        QuickSort.quickSort(srcArr);
        VerifySort.verifySort(srcArr);
    }
}
