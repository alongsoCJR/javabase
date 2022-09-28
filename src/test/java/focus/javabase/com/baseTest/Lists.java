package focus.javabase.com.baseTest;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    /**
     * @Author Jianrong.Chen
     * @Description 新建一个List
     * @Date 2022-09-02 11:12
     * @Param [objs]
     **/
    public static List newArrayList(Object... objs) {
        List result = new ArrayList();
        for (Object obj : objs) {
            result.add(obj);
        }
        return result;
    }

}