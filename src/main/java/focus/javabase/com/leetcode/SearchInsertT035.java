package focus.javabase.com.leetcode;


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
public class SearchInsertT035 {


    //[1,3,5,6], 2   1
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length && target > nums[i]; i++) {
        }
        return i;
    }

    public static int searchInsert1(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        // <= 二分查找 必须加=吗
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        int index = 0;
        if (low == 0) {
            index = target > nums[0] ? 1 : low;
        } else if (low == nums.length - 1) {
            index = target > nums[nums.length - 1] ? nums.length : low;
        } else {
            index = low;
        }

        return index;
    }

    // 递归
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low <= high) {
            int mid = (low + high) >> 1;
            int key = nums[mid];
            if (key == target) {
                return mid;
            } else if (key < target) {
                return binarySearch(nums, mid + 1, high, target);
            } else {
                return binarySearch(nums, low, mid - 1, target);
            }
        }
        return low;
    }

    //{
    //        int low = 0;
    //        int high = nums.length - 1;
    //        int mid = (low + high) >> 1;
    //        while (mid >= low && mid <= high) {
    //            if (nums[mid] > target) {
    //                mid = (low + mid) % 2 == 0 ? (low + mid) / 2 : (low + mid) / 2 - 1;
    //            } else if (nums[mid] < target) {
    //                mid = (mid + high) % 2 == 0 ? (high + mid) / 2 : (high + mid) / 2 + 1;
    //            } else {
    //                return mid;
    //            }
    //
    //        }
    //        return -1;
    //    }
}