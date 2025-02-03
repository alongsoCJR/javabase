package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.basejava.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class APP1 {


    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] result = print2(inputs);
    }

    public static void print(int[][] inputs) {
        Map<Integer, List<Integer>> staticMap = new TreeMap();
        int size = inputs.length;
        // 遍历二维数组
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!staticMap.containsKey(i + j)) {
                    List<Integer> list = Lists.newArrayList();
                    list.add(inputs[i][j]);
                    staticMap.put(i + j, list);
                } else {
                    List<Integer> list = staticMap.get(i + j);
                    list.add(inputs[i][j]);
                }
            }
        }
        // 对Map按照key进行升序排序，使用jdk 1.8的stream排序
        // 遍历Map里面的值
        for (Map.Entry<Integer, List<Integer>> entry : staticMap.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public static int[] print2(int[][] mat) {
        int size = mat.length;
        List<List<Integer>> statisticList = new ArrayList<>(size * 2);
        // 遍历二维数组
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i + j >= statisticList.size()) {
                    statisticList.add(i + j, new ArrayList<>());
                }
                List<Integer> list = statisticList.get(i + j);
                if (!list.isEmpty()) {
                    list.add(mat[i][j]);
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(mat[i][j]);
                    statisticList.add(i + j, newList);
                }
            }
        }
        int[] result = new int[size * size];
        int num = 0;
        for (List<Integer> list : statisticList) {
            for (int i = 0; i < list.size(); i++) {
                result[num++] = list.get(i);
            }
        }
        return result;
    }
}