package focus.javabase.com.algorithm.interview;


/**
 * @Author chenjianrong-lhq
 * @Description wy机试题 获取中位数
 * https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
 * @Date 2020-10-19 09:47
 **/
public class GetMedian {

    public static double getMedian(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merges = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m || j < n) {
            if (i == m) {
                merges[index] = nums2[j];
                j++;
            } else if (j == n) {
                merges[index] = nums1[i];
                i++;
            }

            if (i < m && j < n) {
                if (nums1[i] >= nums2[j]) {
                    merges[index] = nums2[j];
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    merges[index] = nums1[i];
                    i++;
                }
            }
            index++;
        }

        double result = 0;
        if (((m + n) & 1) == 0) {
            // 为偶数
            result = (merges[(m + n) / 2 - 1] + merges[(m + n) / 2]) / 2.0;
        } else {
            // 为奇数
            result = merges[(m + n) / 2];
        }
        return result;
    }

    public static double getMedian1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merges = new int[m + n];
        int i = 0, j = 0, index = 0;
        boolean isEven = ((m + n) & 1) == 0;
        while (i < m || j < n) {

            if (index == (m + n) / 2 + 1) {
                return isEven ? (merges[(m + n) / 2 - 1] + merges[(m + n) / 2]) / 2.0 : merges[(m + n) / 2];
            }

            if (i == m) {
                merges[index] = nums2[j];
                j++;
            } else if (j == n) {
                merges[index] = nums1[i];
                i++;
            }

            if (i < m && j < n) {
                if (nums1[i] >= nums2[j]) {
                    merges[index] = nums2[j];
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    merges[index] = nums1[i];
                    i++;
                }
            }
            index++;
        }
        return isEven ? (merges[(m + n) / 2 - 1] + merges[(m + n) / 2]) / 2.0 : merges[(m + n) / 2];
    }

    public static double getMedian2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m + n == 1) {
            return m == 1 ? nums1[0] : nums2[0];
        }
        int i = 0, j = 0, index = 0;
        boolean isEven = ((m + n) & 1) == 0;
        int first = 0, second = 0;
        while (i < m || j < n) {

            if (index == (m + n) / 2 + 1) {
                return isEven ? (first + second) / 2.0 : second;
            }

            int temp = 0;
            if (i == m) {
                temp = nums2[j];
                j++;
            } else if (j == n) {
                temp = nums1[i];
                i++;
            }

            if (i < m && j < n) {
                if (nums1[i] >= nums2[j]) {
                    temp = nums2[j];
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    temp = nums1[i];
                    i++;
                }
            }
            first = second;
            second = temp;
            index++;
        }
        return isEven ? (first + second) / 2.0 : second;
    }

    // 参考
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}