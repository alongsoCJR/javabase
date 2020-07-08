package focus.javabase.com.leetcode;

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
}