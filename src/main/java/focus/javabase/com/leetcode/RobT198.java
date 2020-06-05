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


}