package focus.javabase.com.leetcode;

public class RotateT189 {

    // 时间复杂度O(k*n)
    public static void rotate(int[] nums, int k) {
        int prev = 0;
        int cur = 0;
        for (int i = 0; i < k; i++) {
            prev = nums[0];
            for (int j = 0; j < nums.length - 1; j++) {
                cur = nums[j + 1];
                nums[j + 1] = prev;
                prev = cur;
            }
            nums[0] = prev;
        }
    }

    // 当nums.len为k的倍数时，会导致重叠一小部分元素
    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = (k % nums.length);
        if (k == 0) return;

        int cur = 0;
        int prev = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index += k;
            index %= nums.length;
            cur = nums[index];
            nums[index] = prev;
            prev = cur;
        }
        nums[(index + k) % nums.length] = prev;
    }


    // 数组拷贝
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = (k % len);
        if (k == 0) return;

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            arr[index] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = arr[i];
        }

    }

    // 环形 参考
    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = (k % len);
        if (k == 0) return;

        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // int count = 0;
    //        int start = 0;
    //        int prev = nums[0];
    //        int cur = 0;
    //        for (int i = 0; count < len; i++) {
    //            start = nums[i];
    //            do {
    //                cur = nums[(i + k) % len];
    //                nums[(i + k) % len] = prev;
    //                prev = cur;
    //                count++;
    //            } while (cur != start);
    //
    //        }
}