package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetRowT119 {

    public static List<Integer> getRow(int rowIndex) {
        assert rowIndex >= 0;
        if (rowIndex == 0) {
            List list = new ArrayList<>();
            list.add(1);
            return list;
        }
        List prevList = getRow(rowIndex - 1);
        int prev = 0;
        List curList = new ArrayList();
        for (int i = 0; i < prevList.size(); i++) {
            int index = (int) prevList.get(i);
            curList.add(prev + index);
            prev = index;
        }
        curList.add(prev);
        return curList;
    }

}