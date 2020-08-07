package focus.javabase.com.leetcode;

public class SortArrayByParityIIT922 {

    // 暴力法
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

    // 两次遍历
    public static int[] sortArrayByParityII1(int[] A) {
        int index = 0;
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                B[index * 2] = A[i];
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 1) {
                B[index * 2 + 1] = A[i];
                index++;
            }
        }
        return B;
    }


    //  双指针
    public static int[] sortArrayByParityII2(int[] A) {
        int index = 1;
        for (int i = 0; i < A.length; i += 2) {
            // 奇数
            if ((A[i] & 1) == 1) {
                while ((A[index] & 1) == 1) {
                    index += 2;
                }
                swap(A, i, index);
            }
        }
        return A;
    }
}