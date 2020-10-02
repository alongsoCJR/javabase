package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumT039 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, result, combine, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            List<Integer> list = new LinkedList<>(combine);
            result.add(list);
            return;
        }

        // 不选择当前元素
        dfs(candidates, target, result, combine, index + 1);

        if (target >= candidates[index]) {
            // 选择当前元素
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], result, combine, index);

            combine.remove(combine.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum0(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> combine = new ArrayList<>();
        dfs0(candidates, target, result, combine, 0);
        return result;
    }


    public void dfs0(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
//        if (index == candidates.length && target == 0) {
//            List<Integer> list = new LinkedList<>(combine);
//            result.add(list);
//        }

        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            List<Integer> list = new LinkedList<>(combine);
            result.add(list);
        }
        // 不选择当前元素
        dfs0(candidates, target, result, combine, index + 1);

        // 选择当前元素
        combine.add(candidates[index]);
        dfs0(candidates, target - candidates[index], result, combine, index + 1);

        combine.remove(combine.size() - 1);

    }
}