package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description tk 机试题
 * @Date 2020-10-19 22:24
 **/
public class MaxSum {


    // 1, -1, 2, -3, 4, 5, 6, 7, -8, 4, 5, -4

    //  max=Math.max(max,sum);
    // if sum<0 sum=nums[i+1]
    // nums[i]<0
    public static int maxSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            // 之和小于0的话，重新开始
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}