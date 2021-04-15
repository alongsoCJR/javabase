package focus.javabase.com.base;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    /**
     * @Author alongso.cjr
     * @Description 根据数据生成List
     * @Date 2021-04-15 09:07
     **/
    public static List<Integer> newArrayList(Integer... nums) {
        List<Integer> arrays = new ArrayList<>();
        for (Integer num : nums) {
            arrays.add(num);
        }
        return arrays;
    }
}