package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author chenjianrong-lhq
 * @Description 统计有多少种组合
 * @Date 2020-10-18 22:37
 **/
public class FindMoneyCombinations {


    public static List<List<Integer>> getAllComBinations(int[] moneys, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> combines = new ArrayList<>();
        getComBinations(moneys, target, result, combines, 0);
        return result;
    }

    public static void getComBinations(int[] moneys, int target, List<List<Integer>> result, List<Integer> combines, int index) {
        if (index == moneys.length) {
            return;
        }

        if (target == 0) {
            result.add(new LinkedList<>(combines));
            return;
        }
        // 不选择moneys[index]
        getComBinations(moneys, target, result, combines, index + 1);

        if (target >= moneys[index]) {
            // 选择moneys[index]
            combines.add(moneys[index]);
            getComBinations(moneys, target - moneys[index], result, combines, index);
            combines.remove(combines.size() - 1);
        }
    }
}