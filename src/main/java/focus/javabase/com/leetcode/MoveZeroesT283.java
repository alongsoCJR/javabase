package focus.javabase.com.leetcode;

public class MoveZeroesT283 {

    // 4, 2, 4, 0, 0, 3, 0, 5, 1, 0
    // 时间复杂度 最坏 O（N^2）
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            j = i;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j < nums.length) {
                swap(nums, i, j);
            }
        }

    }


    // 优化,更容易理解
    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length) {
                    swap(nums, i, j);
                }
            }
        }

    }


    // 冒泡思想
    public static void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    swap(nums, j, j + 1);
                }
            }
        }

    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //int i = 0;
    //        int j = 0;
    //        while (j < nums.length) {
    //            if (nums[i] != 0) {
    //                i++;
    //            }
    //
    //            if (nums[j] == 0) {
    //
    //            }
    //        }
}