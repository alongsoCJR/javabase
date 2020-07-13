package focus.javabase.com.leetcode;

import com.sun.tools.classfile.Annotation;

import java.util.Stack;

public class NextGreaterElementT496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < nums2.length; i++) {
//            stack.push(nums1[i]);
//        }

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int val = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (num == nums2[j]) {
                    while (j < nums2.length - 1) {
                        if (nums2[j + 1] > num) {
                            val = nums2[j + 1];
                            break;
                        }
                        j++;
                    }
                    break;
                }
            }
            nums1[i] = val;

        }
        return nums1;
    }
}