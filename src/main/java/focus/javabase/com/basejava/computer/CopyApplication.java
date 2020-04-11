package focus.javabase.com.basejava.computer;

import java.util.Random;

/**
 * @author chenjianrong-lhq 2019年10月16日 16:32:49
 * @Description: ij数组拷贝测试
 * @ClassName: CopyApplication
 *
 * output:
 *      copyij耗时：8ms
 *      copyij耗时：68ms
 *
 *      questions：（1）存储器的层次化组织  （2）性能 依赖于访问模式，包括怎样遍历多维数组
 *
 */
public class CopyApplication {


    public static void main(String[] args) {

        int[][] src = new int[2048][2048];
        int[][] dest = new int[2048][2048];
        Random random = new Random(47);
        for (int i = 0; i < 2048; i++) {
            for (int j = 0; j < 2048; j++) {
                src[i][j] = random.nextInt(10000);
            }
        }
        long startTime1 = System.currentTimeMillis();
        copyij(src, dest);
        System.out.println("copyij耗时：" + (System.currentTimeMillis() - startTime1));

        int[][] dest1 = new int[2048][2048];
        long startTime2 = System.currentTimeMillis();
        copyji(src, dest1);
        System.out.println("copyij耗时：" + (System.currentTimeMillis() - startTime2));
    }

    private static void copyij(int src[][], int dest[][]) {
        int i, j;
        for (i = 0; i < 2048; i++) {
            for (j = 0; j < 2048; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    private static void copyji(int src[][], int dest[][]) {
        int i, j;
        for (j = 0; j < 2048; j++) {
            for (i = 0; i < 2048; i++) {
                dest[i][j] = src[i][j];
            }
        }
    }

}
