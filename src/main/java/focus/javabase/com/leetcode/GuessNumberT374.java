package focus.javabase.com.leetcode;


import java.util.Scanner;

public class GuessNumberT374 {

    public static int pick = 6;

    public static int guessNumber(int n) {
        return guessBettown(0, n);
    }

    // 二分查找注意 high >= low 这个条件,最后一次比较是high和low可能会出现在同一个问题
    private static int guessBettown(int low, int high) {
        if (high >= low) {
            int mid = low + ((high - low) >> 1);
            int ret = guess(mid);
            if (ret == 0) {
                return mid;
            } else if (ret == 1) {
                return guessBettown(mid + 1, high);
            } else {
                return guessBettown(low, mid - 1);
            }
        }
        return -1;
    }

    public static int guess(int nums) {
        return pick > nums ? 1 : pick == nums ? 0 : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        System.out.println(guess(nums));
    }
}

//if (n >= 1) {
//            int ret = guess(n);
//            if (ret == 0) {
//                return n;
//            } else if (ret == -1) {
//                return guessNumber(n + n / 2);
//            } else {
//                return guessNumber(n >> 1);
//            }
//        }
//        return -1;