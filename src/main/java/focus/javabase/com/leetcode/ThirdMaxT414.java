package focus.javabase.com.leetcode;

public class ThirdMaxT414 {

    public static int thirdMax(int[] nums) {
        int firstNum = Integer.MIN_VALUE;
        int secondNum = Integer.MIN_VALUE;
        int thirdNum = Integer.MIN_VALUE;
        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                flag = false;
            }
            if (nums[i] > firstNum) {
                thirdNum = secondNum;
                secondNum = firstNum;
                firstNum = nums[i];
            } else if (nums[i] < firstNum && nums[i] > secondNum) {
                thirdNum = secondNum;
                secondNum = nums[i];
            } else if (nums[i] < secondNum && nums[i] > thirdNum) {
                thirdNum = nums[i];
            }
        }

        if (thirdNum == Integer.MIN_VALUE && flag && secondNum != Integer.MIN_VALUE) {
            return firstNum;
        }
        return thirdNum;
    }

    public static int thirdMax1(int[] nums) {
        long firstNum = Long.MIN_VALUE;
        long secondNum = Long.MIN_VALUE;
        long thirdNum = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstNum) {
                thirdNum = secondNum;
                secondNum = firstNum;
                firstNum = nums[i];
            } else if (nums[i] < firstNum && nums[i] > secondNum) {
                thirdNum = secondNum;
                secondNum = nums[i];
            } else if (nums[i] < secondNum && nums[i] > thirdNum) {
                thirdNum = nums[i];
            }
        }

        if (thirdNum == Long.MIN_VALUE) {
            return (int) firstNum;
        }
        return (int) thirdNum;
    }
}