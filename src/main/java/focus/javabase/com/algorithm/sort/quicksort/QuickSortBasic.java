package focus.javabase.com.algorithm.sort.quicksort;

/**
 * @author chenjianrong-lhq 2019年07月08日 15:51:11
 * @Description: 常见的快排
 * @ClassName: QuickSortBasic
 */
public class QuickSortBasic {

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 快速排序
     * TODO 最好的情况，nlog(n),最坏的情况，n^2,平均情况--如何证明，nlog(n)【不稳定】
     * TODO 采用生成随机数的方式选取哨兵
     * @Date 2019-07-05 10:19
     * @Param [srcArr]
     *@param arr */
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }


    private static int getPivotIndex(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (high > low && arr[high] >= key) {
                high--;
            }
            arr[low] = arr[high];
            while (high > low && arr[low] <= key) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }
}
