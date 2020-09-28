package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RestoreStringT1528 {

    public static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        // 由于key为 Integer类型，所以 数据结构选择HashMap也行，没有冲突，不会形成链表
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], s.charAt(i));
        }

        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            sb.append(entry.getValue());
        }

        return sb.toString();
    }


    public static String restoreString0(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}