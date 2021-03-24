package focus.javabase.com.leetcode;


import java.util.HashMap;
import java.util.Map;

public class IsIsomorphicT205 {

    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s, t) && isIsomorphic1(t, s);
    }

    private static boolean isIsomorphic1(String t, String s) {
        if ("".equals(s) || "".equals(t) || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), t.charAt(i));
            } else {
                char exceptedChar = hashMap.get(s.charAt(i));
                if (exceptedChar != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }


    // 参考
    public static boolean isIsomorphic0(String s, String t) {
        if ("".equals(s) || "".equals(t) || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s0 = s.charAt(i);
            char t0 = t.charAt(i);
            if ((map1.containsKey(s0) && map1.get(s0) != t0 ||
                    (map2.containsKey(t0) && map2.get(t0) != s0))) {
                return false;
            }
            map1.put(s0, t0);
            map2.put(t0, s0);
        }
        return true;
    }

    // 抓住元素(key-value是否重复这个特性)，重复的话，个数不一样
    public static boolean isIsomorphic2(String t, String s) {
        if ("".equals(s) || "".equals(t) || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), t.charAt(i));
            } else {
                char exceptedChar = hashMap.get(s.charAt(i));
                if (exceptedChar != t.charAt(i)) {
                    return false;
                }
            }
        }
        return hashMap.keySet().size() == new HashMap<>(hashMap).values().size();
    }

}