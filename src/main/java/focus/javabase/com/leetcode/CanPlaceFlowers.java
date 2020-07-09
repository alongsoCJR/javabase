package focus.javabase.com.leetcode;

import java.util.Arrays;

public class CanPlaceFlowers {

    // 1,0,1,0,0,1,0
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int totalCount = (flowerbed.length + 1) / 2;

        int i = 0;
        while (i < flowerbed.length && flowerbed[i] == 0) {
            totalCount = (flowerbed.length - i) / 2;
            i++;
        }

        if (i < flowerbed.length) {
            totalCount = totalCount + i / 2;
        } else {
            totalCount = totalCount + (i + 1) / 2;
        }

        int sum = 0;
        for (int j = 0; j < flowerbed.length; j++) {
            sum += flowerbed[j];
        }
        return totalCount >= (sum + n);
    }

    // 1,0,1,0,0,1,0
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed.length >= 2 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                } else {
                    continue;
                }
            }

            if (i == flowerbed.length - 1) {
                if (flowerbed.length >= 2 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    count++;
                } else {
                    continue;
                }
            }

            if (i > 0 && i < flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }


    // 参考
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int[] arrays = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, arrays, 1, flowerbed.length);
        for (int i = 1; i < arrays.length - 1; i++) {
            if (arrays[i] == 0 && arrays[i + 1] == 0 && arrays[i - 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    //参考 将前面看作有个0 count从1开始计数
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int count = 1;
        int result = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                result += (count - 1) / 2;
                count = 0;
            }
        }
        if (count != 0) result += count / 2;
        return result >= n;
    }
}