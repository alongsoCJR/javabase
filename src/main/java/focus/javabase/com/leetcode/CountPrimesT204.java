/**
 * @(#)CountPrimesT204.java, Feb 08, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jianrong.Chen
 */
public class CountPrimesT204 {

    public static int countPrimes(int n) {
        Map<Integer, Integer> countMap = new HashMap();
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 判断n是否为素数
            boolean isPrimes = isPrimes(i);
            if (isPrimes) {
                count++;
            }
        }
//        return countMap.getOrDefault(n, 0);
        return count;
    }

//    private static boolean isPrimes(int num) {
//        for (int i = 2; i <= num / 2; i++) {
//            if ((num % i) == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static boolean isPrimes(int num) {
        for (int i = 2; i * i <= num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
}