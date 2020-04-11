package focus.javabase.com.algorithm.sort;


/**
 * @Author chenjianrong-lhq
 * @Description 归并排序
 * @Date 2020-04-05 17:42
 **/
public class MergeSort {

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 平均时间复杂度 nlogn 稳定
     * @Date 2020-04-05 18:26
     * @Param [arr, left, right]
     **/
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) >> 1;
            mergeSort(arr, left, middle);                   // 分
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);                // 治、合
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {
        // 定义组合后的数组
        int[] temp = new int[arr.length];
        // 组合数组的下标标识
        int k = low;

        // 左部分的开始下标
        int i = low;
        // 右部分的开始下标
        int j = middle + 1;

        // 从左至右开始遍历
        for (int m = low; m < high; m++) {
            if (m > middle) {
                // 表示左边元素已经处理
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {
                // 表示右边的元素已经处理
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] > arr[j]) {
                // 表示左边的数大于右边，取右边
                temp[k] = arr[j];
                k++;
                j++;
            } else {
                // 表示左边的数小于右边，取左边
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        // 数组的拷贝
        for (int n = 0; n < temp.length; n++) {
            arr[n] = temp[n];
        }
    }
}