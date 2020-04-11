package focus.javabase.com.basejava.computer;

import java.util.Random;

/**
 * @author chenjianrong-lhq 2019年10月16日 17:29:07
 * @Description: 一个异或对的灵活使用
 * @ClassName: EORApplication
 *
 *  output:
 *      swapByEOR耗时：6
 *      swap耗时：27
 */
public class EORApplication {

    public static void main(String[] args) {
        int[][] src = new int[10000][10000];
        int[][] dest = new int[10000][10000];
        Random random = new Random(47);
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                src[i][j] = random.nextInt(10000);
            }
        }

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                swapByEOR(src[i][j], dest[i][j]);
            }
        }
        System.out.println("swapByEOR耗时：" + (System.currentTimeMillis() - startTime1));

        int[][] dest1 = new int[10000][10000];
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                swap(src[i][j], dest1[i][j]);
            }
        }
        System.out.println("swap耗时：" + (System.currentTimeMillis() - startTime2));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("dest[" + i + "]" + "[" + j + "]" + dest[i][j]);
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("dest1[" + i + "]" + "[" + j + "]" + dest1[i][j]);
            }
        }


    }

    /**
     * @Author chenjianrong-lhq
     * @Description 异或的一个灵活使用
     * @Date 2019-10-16 17:44
     * @Param [m, n]
     * @return void
     **/
    private static void swapByEOR(int m, int n) {
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
    }

    /**
     * @Author chenjianrong-lhq
     * @Description 传统的置换方法
     * @Date 2019-10-16 17:45
     * @Param [m, n]
     * @return void
     **/
    private static void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
}
