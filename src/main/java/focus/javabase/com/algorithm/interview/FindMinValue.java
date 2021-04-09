package focus.javabase.com.algorithm.interview;

/**
 * @Author alongso.cjr
 * @Description wy 旋转数组找出最小值
 * @Date 2021-04-09 16:44
 **/
public class FindMinValue {

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int result = toFindMinValue(numbers, 0, numbers.length - 1);
        return result;
    }

    // 递归
    private static int toFindMinValue(int[] arrs, int left, int right) {
        int mid = left + (right - left) / 2;

        if (arrs[mid] == arrs[left] && arrs[right] == arrs[mid]) {
            return searchMinValue(arrs, left, right);
        }
        if (arrs[mid] >= arrs[left]) {
            if (arrs[right] >= arrs[mid]) {
                // 数组连续递增
                return arrs[left];
            } else {
                // 左边连续递增，右边连续递增 [3,4,5] [1,2]
                return toFindMinValue(arrs, mid + 1, right);
            }
        }

        // 非连续递增
        if (arrs[mid] <= arrs[right]) {
            // [3,4,5,0] [1,2,3]
            // 左边递增再从最小值递增，右边全部递增
            return toFindMinValue(arrs, left, mid);
        }
        return -1;
    }

    private static int searchMinValue(int[] arrs, int left, int right) {
        int result = arrs[left];
        for (int i = left + 1; i < right; i++) {
            if (result > arrs[i]) {
                result = arrs[i];
            }
        }
        return result;
    }


    // 这个是完美的二分查找
    public static int binarySearch(int[] arrs, int key) {
        int left = 0;
        int right = arrs.length - 1;
        while (left <= right) {
            // () + 的运算优先级比 >> 高
            int mid = left + ((right - left) >> 1);
            if (arrs[mid] == key) {
                return mid;
            } else if (arrs[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int minArray0(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }


        int index1 = 0;
        int index2 = numbers.length - 1;
        int result = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                result = index2;
                break;
            }

            int mid = index1 + ((index2 - index1) >> 1);
            if (numbers[mid] == numbers[index1] && numbers[index2] == numbers[mid]) {
                return searchMinValue(numbers, index1, index2);
            }
            if (numbers[mid] >= numbers[index1]) {
                index1 = mid;
            } else if (numbers[mid] <= numbers[index2]) {
                index2 = mid;
            }
        }
        return numbers[result];
    }
}