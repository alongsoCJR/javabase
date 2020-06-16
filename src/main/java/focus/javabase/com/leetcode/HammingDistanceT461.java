package focus.javabase.com.leetcode;

public class HammingDistanceT461 {

    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
//            System.out.println(1 << i);
            if (((x & (1 << i)) != (y & (1 << i)))) {
                count++;
            }
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != ((y >> i) & 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(((1 & 4) ^ (4 & 4)) == 1);
    }
}