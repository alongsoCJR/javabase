package focus.javabase.com.leetcode;

/**
 * @Author Jianrong.Chen
 * @Description zj面试题
 * @Date 2022-09-15 20:50
 */
public class RotatedSortedT033 {


    public static int search(int[] nums, int target) {
        return getIndex(nums, target, 0, nums.length - 1);
    }


    // 不存在重复的元素  [4, 5, 6, 7, 0, 1, 2] 0
    public static int getIndex(int[] inputs, int target, int start, int end) {
        if (end >= start) {
            int first = inputs[start];
            int last = inputs[end];
            int midIndex = (start + end) >> 1;
            int mid = inputs[midIndex];
            if (mid == target) {
                return midIndex;
            } else if (first <= target && target < mid) {
                // 如果 first<=target<mid,判断范围缩小[start,mid-1]
                return getIndex(inputs, target, start, midIndex - 1);
            } else if (mid < target && target <= last) {
                // 如果 mid<target<=last,判断范围缩小[mid+1,end]
                return getIndex(inputs, target, midIndex + 1, end);
            } else {
                // 否则,特殊处理[4,5,-2,-1,0,1,2] -2

                // 说明后面部分是递增的，可能出现在后半部分，为什么midIndex + 1是因为已经判断mid != target了
                if (target < first) {
//                    return getIndex(inputs, target, midIndex + 1, end);
                    return getIndex(inputs, target, start + 1, end);
                }
                // 说明前面部分是递增的,可能出现在前半部分
                if (target > last) {
//                    return getIndex(inputs, target, start, midIndex - 1);
                    return getIndex(inputs, target, start, end - 1);
                }
            }
        }
        return -1;
    }


    /**
     * @Author Jianrong.Chen
     * @Description 尝试迭代的方法
     * @Date 2022-09-15 20:46
     * @Param [inputs, target, start, end]
     **/
    public static int getIndex0(int[] inputs, int target, int start, int end) {
        return -1;
    }


    public static int binarySearch(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int left, int right, int target) {
        if (left <= right) {
            //  防止数据类型溢出，使用-
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 中间值比目标值大，说明可能在左边
                return search(nums, left, mid - 1, target);
            } else {
                // 中间值比目标值小，说明可能在右边
                return search(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

}