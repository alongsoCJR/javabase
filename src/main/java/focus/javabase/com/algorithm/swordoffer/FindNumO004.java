package focus.javabase.com.algorithm.swordoffer;


public class FindNumO004 {

    public static boolean find(int[][] nums, int num) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 行数
        int rows = nums.length;
        // 列数
        int columns = nums[0].length;
        // 从左下角开始遍历比较
        // 如果nums[i][j]==num,return true;
        //   nums[i][j]<num,跳过这一列 j++
        //   nums[i][j]>num,跳过这一行 i--
        // 当i,j 超出 rows columns 时，退出循环 返回false
        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j <= columns - 1) {
            if (nums[i][j] == num) {
                return true;
            } else if (nums[i][j] < num) {
                j++;
            } else {
                i--;
            }

        }
        return false;
    }
}