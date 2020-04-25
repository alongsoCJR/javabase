package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针


// [2,4,6,0,0,0] [1,3,5]

public class MergeArraysT083Test extends AbstractTest {


    //    @Before
    public void setUp() throws Exception {
        outputNums = new int[]{1, 2, 3, 0, 0, 0};
        outputNum = 3;
        inputNums = new int[]{2, 5, 6};
        inputNum = 3;
        exceptedNums = new int[]{1, 2, 2, 3, 5, 6};
    }

    @Before
    public void setUp1() throws Exception {
        outputNums = new int[]{2, 4, 6, 0, 0, 0};
        outputNum = 3;
        inputNums = new int[]{1, 3, 5};
        inputNum = 3;
        exceptedNums = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Test
    public void merge() {
        MergeArraysT083.merge1(outputNums, outputNum, inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, outputNums);
    }
}