package focus.javabase.com.leetcode;


//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//


//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

public class MaxSubArrayT053 {

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 判断sum的值是否大于0
            if (sum > 0) {
                sum += nums[i];
            } else {
                // 不大于0就从当前遍历的节点重新累计
                sum = nums[i];
            }

            // 记录最大值
            if (sum > maxSum) {
                maxSum = sum;
            }

        }
        return maxSum;
    }
}