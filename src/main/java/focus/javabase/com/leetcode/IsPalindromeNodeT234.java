package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

public class IsPalindromeNodeT234 {

    // 哈希表
    public static boolean isPalindrome(ListNode head) {
        Map<Integer, Integer> nodeMap = new HashMap<>();
        int index = 0;
        while (head != null) {
            nodeMap.put(++index, head.val);
            head = head.next;
        }

        int len = nodeMap.size();
        for (int i = 1; i <= len / 2; i++) {
            Integer val1 = nodeMap.get(i);
            Integer val2 = nodeMap.get(len - i + 1);
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }
}