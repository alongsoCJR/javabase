package focus.javabase.com.leetcode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//Given two strings s and t , write a function to determine if t is an anagram o
//f s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case?
// Related Topics 排序 哈希表


public class IsAnagramT242 {

    // aa bb  aba  bba
    public static boolean isAnagram(String s, String t) {
        if (s != null && t != null && s.length() != t.length()) {
            return false;
        }
        Map<Character, BigInteger> map1 = new HashMap<>();
        Map<Character, BigInteger> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            putValIntoMap(s.charAt(i), map1);
            putValIntoMap(t.charAt(i), map2);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        Set<Map.Entry<Character, BigInteger>> entrySet = map1.entrySet();
        for (Map.Entry<Character, BigInteger> entry : entrySet) {
            if (map2.get(entry.getKey()) == null ||
                    map2.get(entry.getKey()).compareTo(entry.getValue()) != 0) {
                return false;
            }
        }
        return true;
    }

    private static void putValIntoMap(char c, Map<Character, BigInteger> map) {
        map.put(c, map.getOrDefault(c, BigInteger.ZERO).add(BigInteger.ONE));
    }


    // info
    //			Wrong Answer:
    //			input:"xaaddy"
    //			"xbbccy"
    //			Output:true
    //			Expected:false
    public static boolean isAnagram1(String s, String t) {
        if (s != null && t != null && s.length() != t.length()) {
            return false;
        }
        int ret = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= (s.charAt(i) ^ t.charAt(i));
            a += s.charAt(i);
            b += t.charAt(i);
        }
        return a == b && ret == 0;
    }


    public static boolean isAnagram2(String s, String t) {
        if (s != null && t != null && s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 排序
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
}