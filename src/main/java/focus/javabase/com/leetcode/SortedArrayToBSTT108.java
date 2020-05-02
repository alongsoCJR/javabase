package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

public class SortedArrayToBSTT108 {
    static int[] nums;

    public static TreeNode sortedArrayToBST(int[] nums) {
        assert nums != null;
        SortedArrayToBSTT108.nums = nums;
        return assemBST(0, nums.length - 1);
    }

    private static TreeNode assemBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = assemBST(left, middle - 1);
        root.right = assemBST(middle + 1, right);
        return root;
    }
}