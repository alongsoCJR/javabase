package focus.javabase.com.leetcode;

public class MergeArraysT083 {

    // [2,4,6,0,0,0] [1,3,5]
    // [1,2,4,6,0,0] [1,3,5]
    //2 [1,2,3,4,6,0] [1,3,5]


    // [2,4,6,0,0,0] [1,3,5]
    // [1,2,4,6,0,0] [1,3,5]

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        assert nums1 != null && nums2 != null;
        int point = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = point; j < n && nums2[j] < num1; j++) {
                // 将nums1往后移动一位
                for (int k = nums1.length - 1; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                // 交换两指针的位置
                nums1[i] = nums2[j];
                point++;
                continue;
            }
        }
    }

    //[1,2,3,0,0,0] [2,5,6]
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        assert nums1 != null && nums2 != null;
        for (int i = 0; i < n && m < nums1.length; i++, m++) {
            nums1[m] = nums2[i];
            for (int j = m; j > 0 && nums1[j] < nums1[j - 1]; j--) {
                swapArr(nums1, j, j - 1);
            }
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}