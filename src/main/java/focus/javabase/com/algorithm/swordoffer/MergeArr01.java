package focus.javabase.com.algorithm.swordoffer;

// 已复
public class MergeArr01 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        assert nums1 != null && nums2 == null;
        int p = m - 1, q = m + n - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (p >= 0 && nums1[p] > nums2[i]) {
                swapInt(nums1, p--, q--);
            }
            nums1[q--] = nums2[i];
        }
    }

    private static void swapInt(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static void charuSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapInt(arr, j, j - 1);
                }
            }
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        int i = m + n - 1;
        int num;
        while (p >= 0 || q >= 0) {
            if (p == -1) {
                num = nums2[q--];
            } else if (q == -1) {
                num = nums1[p--];
            } else if (nums1[p] > nums2[q]) {
                num = nums1[p--];
            } else {
                num = nums2[q--];
            }
            nums1[i--] = num;
        }
    }
}