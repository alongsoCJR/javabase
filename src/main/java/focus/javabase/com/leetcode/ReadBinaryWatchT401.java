package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatchT401 {

    // 小时：1、2、4、8  4位
    // 分钟：1，2，4，8，16，32 6位
    public static List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        backTracking(0, num, 0, 0, ans);
        return ans;
    }

    // 参考
    static void backTracking(int i, int num, int hour, int minute, List<String> ans) {
        if (hour > 11 || minute > 59) return;
        if (num > 10 - i) return;//亮灯数大于剩下的位置数
        if (num == 0) {//使用完亮灯数，进行添加
            String minStr = String.valueOf(minute);
            if (minute < 10) {
                minStr = "0" + minStr;
            }
            ans.add(String.valueOf(hour) + ":" + minStr);
            return;
        }

        //不选当前位置
        backTracking(i + 1, num, hour, minute, ans);
        //选取当前位置
        if (i < 4) {//在hour范围内
            hour += (1 << i);
        } else {
            minute += (1 << (i - 4));
        }
        backTracking(i + 1, num - 1, hour, minute, ans);
    }
}


