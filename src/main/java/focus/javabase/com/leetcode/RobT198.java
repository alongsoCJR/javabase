package focus.javabase.com.leetcode;

public class RobT198 {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return robByRecursion(nums, 0, nums.length - 1);
    }

    // {1, 2, 3, 1}
    // 1 {3,1} , {2,3,1}
    // {3,1}  1+3=4
    // {2,3,1}  2 {1} , {3,1}  (2+1,3)  暴力解法，超出时间限制，还以为是死循环导致的
    public static int robByRecursion(int[] nums, int low, int hight) {
        if (hight == low) return nums[hight];
        if (hight > low) {
            if (hight - low == 1) {
                return Integer.max(nums[low], nums[hight]);
            } else {
                return Integer.max(nums[low] + robByRecursion(nums, low + 2, hight),
                        robByRecursion(nums, low + 1, hight));
            }
        }
        return 0;
    }

    // 暴力优化 二分
    public static int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        return robByRecursion1(nums, 0, nums.length - 1);
    }


    public static int robByRecursion1(int[] nums, int low, int hight) {
        if (hight == low) return nums[hight];
        if (hight > low) {
            int middle = low + (hight - low) / 2;
            return Integer.max(nums[middle] + robByRecursion1(nums, low, middle - 2) + robByRecursion1(nums, middle + 2, hight),
                    robByRecursion1(nums, low, middle - 1) + robByRecursion1(nums, middle + 1, hight));
        }
        return 0;
    }


    // 参考
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}