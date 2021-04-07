package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author alongso.cjr
 * @Description ks 对输入的数据 进行范围合并  [1,3][2,4][6,9]   [1,4][6,9]
 * @Date 2021-04-07 17:00
 **/

public class MergeInterval {

    public static List<Interval> merge(List<Interval> list) {
        if (list == null || list.size() == 1) {
            return list;
        }
        // 对list进行排序
        list.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.l - o2.l;
            }
        });

        List<Interval> result = new ArrayList();
        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            List<Interval> mergeList = mergeTwoInterval(result.get(result.size() - 1), list.get(i));
            if (mergeList.size() == 1) {
                result.remove(result.size() - 1);
                result.add(mergeList.get(0));
            } else {
                result.add(mergeList.get(1));
            }
        }
        return result;
    }

    public static List<Interval> mergeTwoInterval(Interval a, Interval b) {
        List<Interval> result = new ArrayList<>();
        // 能合并
        if (a.r >= b.l) {
            Interval merge = new Interval(a.l, Math.max(a.r, b.r));
            result.add(merge);
        } else {
            result.add(a);
            result.add(b);
        }
        return result;
    }
}