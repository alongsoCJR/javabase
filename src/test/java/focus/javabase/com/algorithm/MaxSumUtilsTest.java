package focus.javabase.com.algorithm;

import focus.javabase.com.algorithm.books.MaxSumUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumUtilsTest {

    @Test
    public void maxSum() {
        int[] arrInt = new int[]{-2, 11, -4, 13, -5, -2};
        assertEquals(20, MaxSumUtils.maxSum(arrInt));
    }


    @Test
    public void maxSum0() {
        int[] arrInt = new int[]{-2, 11, -4, 13, -5, -2};
        assertEquals(20, MaxSumUtils.maxSum0(arrInt));
    }

    @Test
    public void maxSum1() {
        int[] arrInt = new int[]{-2};
        assertEquals(-2, MaxSumUtils.maxSum1(arrInt));
    }
}