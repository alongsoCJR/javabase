package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description 有两个升序的整数数组a1 、a2，实现一方法从a1、a2中查找第k小的整数并返回。
 * @Date 2020-10-14 11:57
 **/
public class FindKNum {

    public static void main(String[] args) {
        System.out.println(findK(new int[]{1, 2, 3}, new int[]{2, 3}, 3));
    }

    public static Integer findK(int[] a1, int[] a2, int k) {
        if (a1 == null || a2 == null) {
            System.out.println("非法入参！");
            return null;
        }
        if (k <= 0 || k > a1.length + a2.length) {
            System.out.println("非法入参！");
            return null;
        }
        int i = 0, j = 0;
        int count = 0;
        while (i < a1.length || j < a2.length) {
            count++;
            if (a1[i] > a2[j]) {
                if (count == k) {
                    return a2[j];
                }
                j++;
            } else if (a1[i] < a2[j]) {
                if (count == k) {
                    return a1[i];
                }
                i++;
            } else {
                if (count == k) {
                    return a1[i];
                }
                count++;
                if (count == k) {
                    return a1[i];
                }
                i++;
                j++;
            }
        }
        return null;
    }
}