package focus.javabase.com.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chenjianrong-lhq 2019年07月01日 21:50:18
 * @Description: 数组工具类
 * 1. 实现数据从小到大的排序 sort 冒泡，选择，插入，快排，归并
 * 2. 颠倒数组的顺序 reverse
 * 3. 二分查找法 binarySearch
 * 4. 实现数组的拷贝 copyOf
 * 5. 打印数组 toString
 * 6. 查找数组的下标 indexOf/lastIndexOf
 * 7. 获取元素的最值 getMax/getMin
 * 8. 将数组转化为List集合 asList  prefact 优化
 * @ClassName: ArrayUtils
 */
public class ArrayUtils {

//
//    private static void partition(int[] arr, int left, int right) {
//        if (left < right) {
//            int partition = quicksort(arr, left, right);
//            quicksort(arr, left, partition - 1);
//            quicksort(arr, partition + 1, right);
//        }
//    }
//
//
//    public static int quicksort(int[] arr, int left, int right) {
//        int key = arr[left];
//        while (left < right) {
//            while (right > left && arr[right] >= key) {
//                right--;
//            }
//            arr[left] = arr[right];
//            while (right > left && arr[left] <= key) {
//                left++;
//            }
//            arr[right] = arr[left];
//
//        }
//        arr[left] = key;
//        return left;
//    }


    /**
     * @Description 插入排序
     * TODO 对swap方法的优化，避免多次数据的赋值交换
     **/
    public static void insertSort_improve(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }


    /**
     * @Description 插入排序
     * TODO 避免不必要的重复，最好情况下时间复杂度为 n(o)
     **/
    public static void insertSortImprove(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (key < arr[j]) {
                    swap(arr, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }


    // 时间复杂度 O(n^2) 最坏O(n^2)  最好 O(n^2) 稳定
    public static void chaRuSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    // 时间复杂度 O(n^2) 稳定
    public static void xuanzeSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }

        }

    }

    // 时间复杂度 O(n^2)
    public static void maoPaoSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isOrder = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isOrder = false;
                }
            }
            if (isOrder) {
                break;
            }
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 思考之后的版本，之前的想法傻逼了
     * @Date 2019-07-04 21:21
     * public static int[] bubbleSort(int[] arr) {
     * for (int i = 0; i < arr.length - 1; i++) {
     * for (int j = 1; j < arr.length - i; j++) {
     * if (arr[i] > arr[j]) {
     * swap(arr, i, j);
     * }
     * }
     * }
     * return arr;
     * }
     * / * @Param [arr]
     * TODO 最好【改进的】情况 n,最坏的情况 n^2,平均情况 n^2 【稳定】
     * TODO 性能优化 冒泡排序的改进（对于已经确定排好序的排序，直接退出循环）
     * <p>
     * 还发现一个问题，j=0,不应该是从1开始的，你要把第一个给丢掉？
     **/
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 选择排序
     * TODO 最好,最坏，平均的情况 都是 n^2 【不稳定】
     * @Date 2019-07-04 21:20
     * @Param [arr]
     **/
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 插入排序
     * TODO 最好的情况 n,最坏的情况，n^2,平均情况 n^2 【稳定】 怎么优化
     * @Date 2019-07-04 21:20
     * @Param [srcArray]
     **/
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i - 1; j >= 0 && key < arr[j]; j--) {
                swap(arr, j + 1, j);
            }
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 快速排序
     * TODO 最好的情况，nlog(n),最坏的情况，n^2,平均情况--如何证明，nlog(n)【不稳定】
     * TODO 采用生成随机数的方式选取哨兵
     * @Date 2019-07-05 10:19
     * @Param [srcArr]
     **/
    public static void quickSort(int[] arr) {
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
//            swap(arr, low, high);
            arr[low] = arr[high];
            while (high > low && arr[low] <= key) {
                low++;
            }
//            swap(arr, low, high);
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }


    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 归并排序
     * TODO 最好的情况下，nlog(n),最坏的情况下，nlogn,平均情况下，nlogn【稳定】
     * @Date 2019-07-08 11:25
     * @Param [arr]
     **/
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) >> 1; // >>1与>>>1的区别是什么？
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tempArr = new int[arr.length];
        /** 左半部分数组的下标取值 [low...mid] **/
        int i = low;
        /** 右半部分数组的下标取值 [mid+1...high]**/
        int j = mid + 1;
        int k = low;
//        while (i <= mid && j <= high) {
//            /** 如果左侧比右侧大，取右侧**/
//            if (arr[i] > arr[j]) {
//                tempArr[k] = arr[j];
//                k++;
//                j++;
//            } else {
//                /** 否则，取左侧**/
//                tempArr[k] = arr[i];
//                k++;
//                i++;
//            }
//        }
//
//        while (i <= mid) {
//            /**右半部分元素已经全部处理完毕**/
//            tempArr[k] = arr[i];
//            k++;
//            i++;
//        }
//
//        while (j <= high) {
//            /**左半部分元素已经全部处理完毕**/
//            tempArr[k] = arr[j];
//            k++;
//            j++;
//        }

        for (int m = i; m < high; m++) {
            if (m > mid) {
                /**左半部分元素已经全部处理完毕**/
                tempArr[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {
                /**右半部分元素已经全部处理完毕**/
                tempArr[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] > arr[j]) {
                /**左半部分所指元素 > 右半部分所指元素**/
                tempArr[k] = arr[j];
                k++;
                j++;
            } else {
                tempArr[k] = arr[i];
                k++;
                i++;
            }
        }

        for (int n = 0; n < tempArr.length - 1; n++) {
            arr[n] = tempArr[n];
        }
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 颠倒数组的顺序
     * @Date 2019-07-04 21:20
     * @Param [arr]
     **/
    public static void reverse(int[] arr) {
//        for (int i = 0; i < arr.length / 2; i++) {
//            swap(arr, i, arr.length - 1 - i);
//        }

        /** Collections.reverse中的源码，注意RandomAccess接口的作用**/
        int size = arr.length;
        for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--) {
            swap(arr, i, j);
        }
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 二分查找法
     * @Date 2019-07-04 22:00
     * @Param [arr, i]
     **/
    public static int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 采取递归的方式，迭代的方式怎么写呢？【见源码】
     * @Date 2019-07-04 22:42
     * @Param [arr, key, min, max]
     **/
    private static int binarySearch(int[] arr, int key, int min, int max) {
        if (min < 0 || max > arr.length - 1) {
            throw new IndexOutOfBoundsException("min，max字段数组越界");
        }
        int middle = (min + max) >> 1;
        /** middle < 0不对啊**/
        if (min > max) {
            return -(min + 1);
        }
        int midNum = arr[middle];
        if (midNum == key) {
            return middle;
        } else if (midNum > key) {
            max = middle - 1;
        } else {
            min = middle + 1;
        }
        return binarySearch(arr, key, min, max);
    }


    /**
     * @return int[]
     * @Author chenjianrong-lhq
     * @Description 实现数组的拷贝
     * @Date 2019-07-04 22:42
     * @Param [srcArr, newLength]
     **/
    public static int[] copyOf(int[] srcArr, int newLength) {
        if (newLength < 0) {
            throw new IllegalArgumentException("参数异常");
        }
        if (newLength > srcArr.length) {
            newLength = srcArr.length;
        }
        int[] copy = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            copy[i] = srcArr[i];
        }
        return copy;
    }


    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 打印数组
     * @Date 2019-07-04 22:48
     * @Param [arr]
     **/
    public static void print(int[] arr) {
        if (arr == null) {
            System.out.println("null");
        }
        if (arr.length == 0) {
            System.out.print("[]");
        }
        StringBuilder sb = new StringBuilder().append("[");
        for (int i = 0; ; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]).append("]");
                break;
            }
            sb.append(arr[i]).append(",");
        }
        System.out.println(sb);
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 查找数组的下标
     * todo: 需要优化，没有考虑重复的情况
     * @Date 2019-07-04 22:52
     * @Param [key]
     **/
    public static int indexOf(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 从后面查找数组的下标
     * @Date 2019-07-04 23:02
     * @Param [arr, key]
     **/
    public static int lastIndexOf(int[] arr, int key) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == key) {
                /** 这里返回数据错了，参照一下ArrayLis.lastIndexOf()的源码**/
                return arr.length - 1 - i;
            }
        }
        return -1;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 获取元素的最大值
     * @Date 2019-07-04 22:59
     * @Param [arr]
     **/
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 获取元素的最小值
     * @Date 2019-07-04 23:00
     * @Param [arr]
     **/
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    /**
     * @return java.util.List<java.lang.Integer>
     * @Author chenjianrong-lhq
     * @Description 将数组转化为List集合
     * @Date 2019-07-05 09:24
     * @Param [arr]
     **/
    public static List<Integer> asList(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        return arrList;
    }


    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 置换数组下标i，j的值
     * @Date 2019-07-03 23:09
     * @Param [arr, i, j]
     **/
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description 二分法排序
     * <p>
     * todo 二分法查找只适用于排好序的数组，如果数组为空，是有序的，找到应该插入的位置，这样是不是也可以的
     * @Date 2019-07-24 18:37
     * @Param [array]
     **/
    public static void binarySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int left, right, num, middle, j;
            left = 0;
            right = i - 1;
            num = array[i];
            // 二分法查找插入位置
            while (right >= left) {
                // 指向已排序好的中间位置
                middle = (left + right) / 2;
                if (num < array[middle]) {
                    right = middle - 1;// 插入的元素在右区间
                } else {
                    left = middle + 1;// 插入的元素在左区间
                }
            }
            // 后移排序码大于R[i]的记录
            for (j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            // 插入
            array[left] = num;
        }
    }

}
