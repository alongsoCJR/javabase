package focus.javabase.com.algorithm.interview;

import focus.javabase.com.base.Lists;

import java.util.*;

/**
 * @Author alongso.cjr
 * @Description moka 找出是否存在薪资循环依赖
 * @Date 2021-04-15 10:18
 **/
public class SalaryItem {

    // 现在有n个工资项目和m组依赖关系，找到合理的计算工资顺序，如果有循环依赖，请输出无法计算
    public static void main(String[] args) {
        List<SalaryItem> salaryItems = new LinkedList<SalaryItem>();
        salaryItems.add(new SalaryItem(0, "考勤信息", new ArrayList<Integer>()));
        salaryItems.add(new SalaryItem(1, "税费", Lists.newArrayList(3)));
        salaryItems.add(new SalaryItem(2, "基础薪资", new ArrayList<Integer>()));
        salaryItems.add(new SalaryItem(3, "应发工资", Lists.newArrayList(5, 4, 2)));
        salaryItems.add(new SalaryItem(4, "奖金", Lists.newArrayList(5, 2, 1)));
        salaryItems.add(new SalaryItem(5, "全勤奖", Lists.newArrayList(0)));

        checkSalaryItems(salaryItems);
    }

    private static void checkSalaryItems(List<SalaryItem> salaryItems) {
        Map<Integer, List<Integer>> itemsMap = new HashMap<>();
        // 放入Map中
        for (int i = 0; i < salaryItems.size(); i++) {
            SalaryItem item = salaryItems.get(i);
            itemsMap.put(item.getId(), item.getDependencyItemIds());
        }
        // 逐个遍历
        for (int i = 0; i < salaryItems.size(); i++) {
            SalaryItem item = salaryItems.get(i);
            Set<Integer> dependencyItemIds = null;
            try {
                dependencyItemIds = getAllDependencyItemIds(item.getId(), itemsMap, new HashSet<>(), new HashSet<>());
            } catch (Exception ex) {
                System.out.println("薪资项Name=" + item.getItemNmae() + ",Id=" + item.getId() + "无法计算!");
                break;
            }
            System.out.println("薪资项Name=" + item.getItemNmae() + ",Id=" + item.getId() + ",需要依赖计算的指标id" + dependencyItemIds);
        }
    }


    private static Set<Integer> getAllDependencyItemIds(int itemId, Map<Integer, List<Integer>> itemsMap, HashSet<Integer> allItems, HashSet<Integer> parentItems) throws Exception {
        List<Integer> dependencyItemIds = itemsMap.get(itemId);
        if (dependencyItemIds == null || dependencyItemIds.isEmpty()) {
            return allItems;
        }
        parentItems.add(itemId);
        for (int dependencyItemId : dependencyItemIds) {
            if (parentItems.contains(dependencyItemId)) {
                throw new Exception("无法计算！");
            }
            allItems.add(dependencyItemId);
            // 5 -> 3 1,4-> 3 1,2->3 1

            Set<Integer> subAllItems = getAllDependencyItemIds(dependencyItemId, itemsMap, new HashSet<>(), new HashSet<>(parentItems));
            allItems.addAll(subAllItems);
        }
        return allItems;
    }


    Integer id;
    String itemNmae;
    List<Integer> dependencyItemIds;

    public SalaryItem(Integer id, String itemNmae, List<Integer> dependencyItemIds) {
        this.id = id;
        this.itemNmae = itemNmae;
        this.dependencyItemIds = dependencyItemIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNmae() {
        return itemNmae;
    }

    public void setItemNmae(String itemNmae) {
        this.itemNmae = itemNmae;
    }

    public List<Integer> getDependencyItemIds() {
        return dependencyItemIds;
    }

    public void setDependencyItemIds(List<Integer> dependencyItemIds) {
        this.dependencyItemIds = dependencyItemIds;
    }
}