package focus.javabase.com.algorithm.interview;


/**
 * @Author chenjianrong-lhq
 * @Description 青蛙跳到n的位置，每次只能跳3步或者5步，请问最少跳的次数是多少
 * @Date 2020-03-30 08:49
 **/
public class FrogStip {

    public static final int[] arrs = {7, 11, 18, 200, 999, 1000, 34, 560};

    public static void main(String[] args) {
        for (int i = 0; i < arrs.length; i++) {
            int m = arrs[i];
            System.out.print("输入的位置为：" + m);
            // 获取遍历的次数
            int n = m / 5;

            int minCount = m / 3;
            int x = 0, y = 0;    // x表示走3步的次数,y表示走5步的次数
            boolean canFinish = false;
            // 遍历
            for (int j = 0; j <= n; j++) {
                int k = (m - 5 * j) % 3;
                if (k == 0) {
                    y = j;
                    x = (m - 5 * j) / 3;
                    canFinish = true;
                    int totalCount = x + y;
                    if (totalCount < minCount) {
                        minCount = totalCount;
                    }
                }
            }

            if (canFinish) {
                System.out.println(" 最少次数为" + minCount + ",走3步的次数:" + x + " ,走5步的次数" + y);
            } else {
                System.out.println(" 无法到达指定位置：" + m);
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            int m = arrs[i];
            System.out.print("输入的位置为：" + m);
            if (minStep(m) == -1) {
                System.out.println(" 无法到达指定位置：" + m);
            } else {
                System.out.println("最少次数为" + minStep(m));
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            int m = arrs[i];
            System.out.print("输入的位置为：" + m);
            if (minStep(m) == -1) {
                System.out.println(" 无法到达指定位置：" + m);
            } else {
                System.out.println("最少次数为" + minStep(m));
            }
        }
    }


    public static int jump(int n) {
        if (n == 3 || n == 5) {
            return 1;
        }
        if (n < 5) {

        }
        return Math.min(jump(n - 3) + 1, jump(n - 5) + 1);
    }


    public static int jump0(int n) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }
        int tmp3 = jump0(n - 3);
        int tmp5 = jump0(n - 5);
        if (tmp3 == -1 && tmp5 == -1) {
            return -1;
        }
        if (tmp3 == -1) {
            return tmp5 + 1;
        }
        if (tmp5 == -1) {
            return tmp3 + 1;
        }
        return Math.min(tmp3, tmp5) + 1;
    }

    public static int minStep(int n) {
        if (n == 3 || n == 5){
            return 1;
        }
        if (n < 5){
            return -1;
        }
        int [] arr = new int[n];
        arr[0] = -1;
        arr[1] = -1;
        arr[2] = 1;
        arr[3] = -1;
        arr[4] = 1;
        for(int i = 5; i< n; i++){
            arr[i] = -1;
            if (arr[i-3] != -1) {
                arr[i] = arr[i-3] +1;
            }
            if (arr[i-5] != -1) {
                if (arr[i] == -1) {
                    arr[i] = arr[i-5] +1;
                    continue;
                }
                arr[i] = Math.min(arr[i-5] + 1, arr[i]);
            }
        }
        return arr[n-1];
    }
}