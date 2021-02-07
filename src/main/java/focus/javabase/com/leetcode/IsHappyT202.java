/**
 * @(#)IsHappyT202.java, Feb 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jianrong.Chen
 */
public class IsHappyT202 {

    //19
    //1^2 + 9^2 = 82
    //8^2 + 2^2 = 68
    //6^2 + 8^2 = 100
    //1^2 + 0^2 + 0^2 = 1
    // 2
    // 4
    // 16
    // 6^2+1^2=37
    // 7^2+3^2=49+9=58
    // 8^2+5^2=64+25=89
    // 9^2+8^2=81+64=145
    // 5^2+4^2+1^2=25+16+1=42
    // 2^2+4^2=20
    // 0^2+2^2=4;
    private static Map<Integer, Boolean> flagMap = new HashMap<>();

    // 递归？
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (flagMap.containsKey(n)) {
            return false;
        }
        // 19
        int m = n;
        int sqart = 0;
        while (n > 0) {
            sqart += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (sqart == 1) {
            return true;
        } else {
            flagMap.put(m, false);
            return isHappy(sqart);
        }
    }

    // 迭代
    public static boolean isHappy0(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int sqart = 0;
        while (n > 0) {
            sqart += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sqart;
    }
}