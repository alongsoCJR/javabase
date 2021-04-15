package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author alongso.cjr
 * @Description moka 根据输入部门id找出所有下级部门
 * @Date 2021-04-15 10:18
 **/
public class DepartmentTest {

    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);
        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);

        List<Department> subDepartments = DepartmentTest.getSub(1, allDepartment, new ArrayList<>());
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    /**
     * 根据id，获取所有子部门列表
     *
     * @param id
     * @return
     */
    private static List<Department> getSub(int id, List<Department> allDepartment, List<Department> result) {
        if (allDepartment == null || allDepartment.size() == 0) {
            return new ArrayList<>();
        }

        List<Department> allItem = new ArrayList();
        for (Department department : allDepartment) {
            if (id == department.getPid()) {
                allItem.add(department);
            }
        }

        if (allItem.size() > 0) {
            for (Department department : allItem) {
                List<Department> subItem = getSub(department.getId(), allDepartment, new ArrayList<>());
                if (subItem.size() > 0) {
                    result.addAll(subItem);
                }
            }
            result.addAll(allItem);
        }
        return result;
    }
}

class Department {
    /**
     * id
     */
    private int id;
    /**
     * parent id
     */
    private int pid;
    /**
     * 名称
     */
    private String name;

    public Department(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}