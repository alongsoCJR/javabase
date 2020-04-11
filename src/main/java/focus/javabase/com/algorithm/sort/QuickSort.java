package focus.javabase.com.algorithm.sort;

import java.util.Random;

public class QuickSort {


    /**
     * @Description 快速排序
     * TODO 使用分而治之的思想,平均时间复杂度为O(nlgn)
     * 最坏的情况是选到的哨兵两个极端（最大值/最小值），导致O(n^2)
     **/
    public static void quickSort(int[] arr) {
        quick_sort(arr, 0, arr.length - 1);

    }

    private static void quick_sort(int[] arr, int min, int max) {
        if (max > min) {
            int partIndex = partition(arr, min, max);
            quick_sort(arr, min, partIndex - 1);
            quick_sort(arr, partIndex + 1, max);
        }
    }

    private static int partition(int[] arr, int min, int max) {
        Random random = new Random(47);
        int index = random.nextInt(max - min) + min;
        int key = arr[index];

        while (max > min) {
            while (max > min && arr[max] >= key) {
                max--;
            }
            //
            arr[min] = arr[max];

            while (max > min && arr[min] <= key) {
                min++;
            }
            //
            arr[max] = arr[min];
        }
        arr[max] = key;
        return max;
    }
}