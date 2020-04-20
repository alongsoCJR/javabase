package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMex {


    // 1, 2, 3, 5, 6, 3, 2 O(n^2)的时间复杂度
    public static int getMex(int[] A, int n) {
        assert A != null && A.length > 0 && n > 0;
        // 插排(为什么要考虑排序呢)
//        for (int i = 1; i < A.length; i++) {
//            for (int j = i; j > 0 && A[j - 1] > A[j]; j--) {
//                swapArr(A, j, j - 1);
//            }
//
//        }

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            arrayList.add(A[i]);
        }

        for (int m = 1; m < n; m++) {
            if (!arrayList.contains(m)) {
                return m;
            }
        }
        return -1;
    }

    private static void swapArr(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    //  O(n)时间复杂度
    public static int getMex1(int[] A, int n) {
        assert A != null && A.length > 0 && n > 0;
        // 放入到Map当中
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], A[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

}
