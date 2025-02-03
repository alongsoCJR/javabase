package focus.javabase.com.leetcode;

public class LengthOfLIST300 {

    // 10, 9, 2, 5, 3, 7, 101, 18
    public static int lengthOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                    ans = Math.max(counts[i], ans);
                }
            }
        }
        return ans;
    }
}