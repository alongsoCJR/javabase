package focus.javabase.com.algorithm;

import focus.javabase.com.algorithm.sort.quicksort.QuickSort3Way;
import focus.javabase.com.algorithm.sort.quicksort.QuickSortBasic;
import focus.javabase.com.algorithm.sort.quicksort.QuickSortDualPivot;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * @author chenjianrong-lhq 2019年07月08日 15:55:07
 * @Description: 三种快排的性能测试类
 * @ClassName: QuickSortTest
 */
public class QuickSortTest {

    int[] input = new int[20000000];

    /**
     * Random Data[length=10000000]
     * TODO:QuickSortBasic.sort()耗时：1160ms
     *      QuickSort3Way.sort()耗时：996ms
     *      QuickSortDualPivot.sort()耗时：796ms
     * <p>
     * Duplicate Data[length=10000000,data in(0,999)] :
     * TODO:QuickSortBasic.sort()耗时：14837ms
     *      QuickSort3Way.sort()耗时：458ms
     *      QuickSortDualPivot.sort()耗时：387ms
     *
     **/
    @Before
    public void setUp() {
        Random random = new Random(47);
        for (int i = 0; i < 20000000; i++) {
            input[i] = random.nextInt(20000000);
        }
    }

    @Test
    public void testQuickSortBasic() {
        long startTime = System.currentTimeMillis();
        QuickSortBasic.sort(input);
        System.out.println("QuickSortBasic.sort()耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testQuickSort3Way() {
        long startTime = System.currentTimeMillis();
        QuickSort3Way.sort(input);
        System.out.println("QuickSort3Way.sort()耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testQuickSortDualPivot() {
        long startTime = System.currentTimeMillis();
        QuickSortDualPivot.sort(input);
        System.out.println("QuickSortDualPivot.sort()耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
