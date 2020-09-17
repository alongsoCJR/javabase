package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalTraversalT987 {


    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Condition> conditions = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(root, 0, 0, conditions);
        Collections.sort(conditions);
        // 参考优化
        int prev = Integer.MIN_VALUE;
        for (Condition condition : conditions) {
            List<Integer> item = result.get(result.size() - 1);
            if (item.size() == 0) {
                item.add(condition.val);
            } else {
                if (prev == condition.x) {
                    item.add(condition.val);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(condition.val);
                    result.add(list);
                }
            }
            prev = condition.x;
        }
        return result;
    }

    public static List<List<Integer>> verticalTraversa0(TreeNode root) {
        List<Condition> conditions = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(root, 0, 0, conditions);
        Collections.sort(conditions);
        int prev = conditions.get(0).x;
        for (Condition condition : conditions) {
            if (condition.x != prev) {
                result.add(new ArrayList<>());
                prev = condition.x;
            }
            List<Integer> item = result.get(result.size() - 1);
            item.add(condition.val);
        }
        return result;
    }

    private static void dfs(TreeNode root, int x, int y, List list) {
        if (root != null) {
            Condition condition = new Condition(x, y, root.val);
            list.add(condition);
            dfs(root.left, x - 1, y - 1, list);
            dfs(root.right, x + 1, y - 1, list);
        }
    }
}


class Condition implements Comparable<Condition> {

    int x;
    int y;
    int val;

    public Condition(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Condition obj) {
        if (obj.x == x) {
            if (obj.y == y) {
                // 比较 val
                return obj.val < val ? 1 : -1;
            } else {
                return obj.y < y ? -1 : 1;
            }
        } else {
            // 比较x
            return obj.x < x ? 1 : -1;
        }
    }
}