package focus.javabase.com.algorithm.swordoffer;

/**
 * @Author chenjianrong-lhq
 * @Description 剑指offer 第五题 合并两个有序数组
 * @Date 2020-10-04 18:01
 **/
public class MergeArr {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        assert nums1 != null && nums2 != null;
        // 为nums1的末尾指针
        int p = m - 1;
        // 找到比较后应该插入的位置，起初为m + n - 1
        int q = m + n - 1;

        // 从后面开始遍历数组nums2
        for (int i = n - 1; i >= 0; i--) {
            // 如果nums1[p] > nums2[i]
            while (p >= 0 && nums1[p] > nums2[i]) {
                // 交换这两个值，交换后p，q往前移一位
                swapArr(nums1, p--, q--);
            }
            // 否则，将大的值放置q位置，q往前移一位
            nums1[q--] = nums2[i];
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}