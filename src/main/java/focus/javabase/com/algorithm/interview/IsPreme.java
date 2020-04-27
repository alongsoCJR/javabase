package focus.javabase.com.algorithm.interview;

import java.util.*;

public class IsPreme {

    // 求某个数是否是质数
    public static boolean isPreme(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    // 求100以内的质数
    public static Integer[] getPremes(int num) {
        List<Integer> arrs = new ArrayList();
        for (int i = 2; i <= num; i++) {
            if (isPreme(i)) {
                arrs.add(i);
            }
        }
        Integer[] result = new Integer[arrs.size()];
        result = arrs.toArray(result);
        return result;
    }

    // 求100能被两个质数分解的分解方式
    //2  0
    //5   1
    //10  2
    //18  2
    //0   end
    public static int decompositionWays(int num) {
        int count = 0;
        Integer[] result = getPremes(num);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= result.length - 1; i++) {
            int first = result[i];
            for (int j = 0; j <= result.length - 1; j++) {
                if (first + result[j] == num && !map.containsKey(first)) {
                    map.put(result[j], j);
                    count++;
                    System.out.println("第" + count + "种组合：" + first + "-" + result[j]);
                }
            }
        }
        return count;
    }

    // 10 -> 2,3,5,7
    // 2 3 5
    public static int decompositionWays1(int num) {
        int count = 0;
        Integer[] result = getPremes(num);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= result.length - 1; i++) {
            if (!map.containsKey(num - result[i])) {
                map.put(result[i], 1);
            }
        }

        for (int i = 0; i <= result.length-1; i++) {
            if (map.containsKey(num - result[i])) {
                count++;
                System.out.println("第" + count + "种组合：" + result[i] + "-" + (num - result[i]));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            decompositionWays1(a);
//            Arrays.asList(getPremes(a)).stream().forEach(x -> System.out.print(x + " "));
//            Arrays.asList(getPremes(a)).stream().forEach(System.out::print);
        }
    }

    //第1种组合：3-97
    //第2种组合：11-89
    //第3种组合：17-83
    //第4种组合：29-71
    //第5种组合：41-59
    //第6种组合：47-53
}