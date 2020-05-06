package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.List;


public class GenerateT118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            List<Integer> firstList = new ArrayList<>();
            firstList.add(1);
            result.add(firstList);
            return result;
        }

        List<List<Integer>> prevList = generate(numRows - 1);
        List<Integer> lastList = prevList.get(prevList.size() - 1);
        int prev = 0;
        List<Integer> curList = new ArrayList<>();
        for (int i = 0; i < lastList.size(); i++) {
            int index = lastList.get(i);
            curList.add(prev + index);
            prev = index;
        }
        curList.add(prev);
        prevList.add(curList);
        return prevList;
    }
}