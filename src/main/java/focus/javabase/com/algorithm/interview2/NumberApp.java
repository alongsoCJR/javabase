package focus.javabase.com.algorithm.interview2;


import java.util.Arrays;

import static focus.javabase.com.leetcode.SortByBitsT1356.swap;

// 给定一个数组,在不开辟新的内存空间的情况下将其中所有的0移动至数组开头。
//例:
//输入：
//	[0, 8, 5, 0, 134, 0, 3, 6, 5, 0, 7, 0]
//输出：
//	[0,0,0,0,0,8,5,134,3,6,5,7]

// 已复
public class NumberApp {


    public static void main(String[] args) {

//        int[] inputs = new int[]{0, 0, 1};
        int[] inputs = new int[]{0, 0, 8, 5, 0, 134, 0, 3, 6, 5, 0, 7, 0, 0};
        int[] outputs = moveZero3(inputs);
        System.out.println(Arrays.toString(outputs));
    }


    // 冒泡思想
    public static int[] moveZero(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (nums[j] == 0) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }


    public static int[] moveZero1(int[] inputs) {
        int j = 0; // 记录0的个数
        for (int i = inputs.length - 1; i > 0; i--) {
            if (inputs[i] == 0) {
                j++;
            } else {
                inputs[i + j] = inputs[i];
                inputs[i] = 0;
            }
        }
        return inputs;
    }

    // 这个比较容易理解
    public static int[] moveZero2(int[] inputs) {
        int j = inputs.length - 1; // 记录0的个数
        for (int i = inputs.length - 1; i > 0; i--) {
            if (inputs[i] != 0) {
                inputs[j--] = inputs[i];
            }
        }

        for (int i = 0; i < j; i++) {
            inputs[i] = 0;
        }

        return inputs;
    }

    // 双指针
    public static int[] moveZero3(int[] inputs) {
        int n = inputs.length - 1, left = n, right = n;
        while (left > 0) {
            if (inputs[left] != 0) {
                swapInt(inputs, left, right--);
            }
            left--;
        }
        return inputs;
    }

    // 移动至末尾
    public static int[] moveZeroToFoot(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i; j < nums.length - 1; j++) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
        return nums;
    }


    // 移动至末尾
    public static int[] moveZeroToFoot1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


    // 移动至末尾
    public static int[] moveZeroToFoot2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swapInt(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    private static void swapInt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}