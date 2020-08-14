package focus.javabase.com.leetcode;


import java.util.Arrays;

public class SortByBitsT1356 {


    // 冒泡
    public static int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ((bitCount(arr[j]) == bitCount(arr[j + 1]) && (arr[j] > arr[j + 1]) || bitCount(arr[j]) > bitCount(arr[j + 1]))) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    // Integer.bitCount
    public static int[] sortByBits2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ((Integer.bitCount(arr[j]) == Integer.bitCount(arr[j + 1]) && (arr[j] > arr[j + 1])
                        || Integer.bitCount(arr[j]) > Integer.bitCount(arr[j + 1]))) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    // n&(n-1)
    public int countBits2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    // 参考
    public static int[] sortByBits3(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b)).mapToInt(Integer::intValue).toArray();
    }


    // 参考
    public static int[] sortByBits4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }


    public static int bitCount(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) > 0) {
                count++;
            }
        }
        return count;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits5(new int[]{3, 4, 6, 7, 11, 1, 2, 3})));
    }


    // 快排
    public static int[] sortByBits5(int[] arr) {
        sortQuick(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sortQuick(int[] arr, int min, int max) {
        if (max > min) {
            int partition = partition(arr, min, max);
            sortQuick(arr, min, partition - 1);
            sortQuick(arr, partition + 1, max);
        }
    }

    private static int partition(int[] arr, int min, int max) {
        int key = arr[min];
        while (max > min) {
            while (max > min && compare(key, arr[max])) {
                max--;
            }

            arr[min] = arr[max];

            while (max > min && compare(arr[min], key)) {
                min++;
            }

            arr[max] = arr[min];
        }
        arr[min] = key;
        return min;
    }

    private static boolean compare(int num1, int num2) {
        return ((Integer.bitCount(num1) != Integer.bitCount(num2) || (num1 <= num2))
                && (Integer.bitCount(num1) <= Integer.bitCount(num2)));
    }
}