package focus.javabase.com.algorithm.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author alongso.cjr
 * @Description zj 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 参考：LEETCODE128 https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/
 * @Date 2021-04-01 22:01
 **/
public class LongestSequence {


    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
//        int[] nums = new int[]{100, 4, 200, 0, 3, 2, 5, 6};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(getLongest(nums));
        System.out.println(getLongest0(nums));
        Pair p = calculate(nums);
        //得到的结果是6，5 说明结尾的数字是6，总共5个数 6包含自己往前推5个数 2，3，4，5，6
        System.out.println(p.left + ";" + p.right);

    }

    // 100,4,200,1,3,2
    public static int getLongest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int count = 1;
            int prev = num - 1;
            while (set.remove(prev)) {
                count++;
                prev--;
            }

            int next = num + 1;
            while (set.remove(next)) {
                count++;
                next++;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    public static int getLongest0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = 1;
            int prev = num - 1;
            if (countMap.containsKey(prev)) {
                count += countMap.get(prev);
            } else {
                while (set.contains(prev)) {
                    count++;
                    prev--;
                }
            }

            int next = num + 1;
            if (countMap.containsKey(next)) {
                count += countMap.get(next);
            } else {
                while (set.contains(next)) {
                    count++;
                    next++;
                }
            }

            countMap.put(num, count);
            max = Math.max(max, count);
        }
        return max;
    }


    public static class Pair {
        private Integer left;
        private Integer right;

        public Pair() {

        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public Integer getRight() {
            return right;
        }

        public void setRight(Integer right) {
            this.right = right;
        }
    }

    // FROM XR
    private static Pair calculate(int[] arr) {
        Pair p = new Pair();
        Map<Integer, Integer> map = changeArraysToMap(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 1;
            while (map.get(++num) != null) {
                count++;
            }
            max = Math.max(count, max);
            p.left = num - 1; //最后结尾的数
            p.right = max;  //总共有几个数
        }
        return p;
    }

    private static Map<Integer, Integer> changeArraysToMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], arr[i]);
        }
        return map;
    }
}