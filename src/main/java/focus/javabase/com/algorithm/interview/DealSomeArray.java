package focus.javabase.com.algorithm.interview;

/**
 * @Author alongso.cjr
 * @Description sh 将递增数组不同的元素保留在数组的前部分，后部分不用管
 * @Date 2021-04-09 22:57
 **/
public class DealSomeArray {

    public static int[] dealSomeItem(int[] arrs) {
        if (arrs == null || arrs.length == 0 || arrs.length == 1) {
            return arrs;
        }
        int fast = 1, slow = 0;
        while (fast <= arrs.length - 1) {
            while (arrs[fast] == arrs[slow]) {
                fast++;
            }
            // swap ++slow fast++
            swap(arrs, ++slow, fast++);
        }

        return arrs;
    }

    private static void swap(int[] arrs, int m, int n) {
        int temp = arrs[m];
        arrs[m] = arrs[n];
        arrs[n] = temp;
    }
}