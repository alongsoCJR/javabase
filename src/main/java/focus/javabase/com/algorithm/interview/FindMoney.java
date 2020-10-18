package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description 找钱 只统计不同的方法个数
 * @Date 2020-10-14 11:07
 **/
public class FindMoney {

    static int result = 0;

    public static void main(String[] args) {
        int[] arrs = new int[]{1, 5, 10, 20, 50, 100};
        int target = 10;
        getAllComBinations(arrs, 0, target);
        System.out.println(result);
    }

    // 1,5,10,20,50,100 --> 200
    // 1,5,10,20,50,100  199
    // 5,10,20,50,100  200
    // target<=0
    public static void getAllComBinations(int nums[], int index, int target) {
        if (nums.length == index) {
            return;
        }

        if (target == 0) {
            result++;
            return;
        }
        // 不选择
        getAllComBinations(nums, index + 1, target);
        // 只有大于nums[index]时，才能选择
        if (target >= nums[index]) {
            getAllComBinations(nums, index, target - nums[index]);
        }
    }
}