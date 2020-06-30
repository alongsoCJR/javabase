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

    // 4, 2, 4, 0, 0, 3, 0, 5, 1, 0
    public static void moveZeroes3(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                i++;
            }
            if (nums[j] != 0) {
                j++;
            }

            if (i > j && i < nums.length && nums[i] != 0) {
                swap(nums, i++, j++);
            } else {
                i++;
            }

        }

    }


    // 参考
    public static void moveZeroes4(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[tmp++] = nums[i];
            }
        }

        for (int i = tmp; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    // 参考
    public static void moveZeroes5(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}