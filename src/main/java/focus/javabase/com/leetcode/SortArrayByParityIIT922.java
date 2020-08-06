package focus.javabase.com.leetcode;

public class SortArrayByParityIIT922 {

    public static int[] sortArrayByParityII(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            // 优化
            if (((i ^ A[i]) & 1) == 0) continue;

            j = i + 1;
            if ((i & 1) == 1) {
                // 偶数,找到下一个奇数在偶数位
                while (j < A.length) {
                    if ((j & 1) == 0 && (A[j] & 1) == 1) {
                        swap(A, i, j);
                    }
                    j++;
                }

            } else {
                // 奇数，找到下一个偶数在奇数位
                while (j < A.length) {
                    if ((j & 1) == 1 && (A[j] & 1) == 0) {
                        swap(A, i, j);
                    }
                    j++;
                }
            }
        }
        return A;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}