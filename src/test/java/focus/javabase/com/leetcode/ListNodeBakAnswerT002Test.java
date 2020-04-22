package focus.javabase.com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNodeBakAnswerT002Test {

    List<Integer> targetList = new ArrayList<>();

    /**
     * 还没有考虑两链表长度不等的情况与进位的情况
     **/
    @Test
    public void addTwoNumbers() {
        /**[2,4,3]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(2);
        listNodeBak1.next = new ListNodeBak(4);
        listNodeBak1.next.next = new ListNodeBak(3);

        /**[5,6,4]**/
        ListNodeBak listNodeBak2 = new ListNodeBak(5);
        listNodeBak2.next = new ListNodeBak(6);
        listNodeBak2.next.next = new ListNodeBak(4);

        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, listNodeBak2);
        while (resultListNodeBak != null) {
            /**except output [7,0,8]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{7, 0, 8}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 考虑末尾进位的情况
     **/
    @Test
    public void addTwoNumbers1() {
        /**[5]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(5);

        /**[5]**/
        ListNodeBak listNodeBak2 = new ListNodeBak(5);

        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, listNodeBak2);
        while (resultListNodeBak != null) {
            /**except output [0,1]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 两链表长度不等
     **/
    @Test
    public void addTwoNumbers2() {
        /**[3，5]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(3);
        listNodeBak1.next = new ListNodeBak(5);

        /**[5]**/
        ListNodeBak listNodeBak2 = new ListNodeBak(5);

        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, listNodeBak2);
        while (resultListNodeBak != null) {
            /**except output [0,4]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{8, 5}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }


    /**
     * 两链表长度不等,最高位需要连续两次进位
     **/
    @Test
    public void addTwoNumbers3() {
        /**[9,9]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(9);
        listNodeBak1.next = new ListNodeBak(9);

        /**[1]**/
        ListNodeBak listNodeBak2 = new ListNodeBak(1);

        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, listNodeBak2);
        while (resultListNodeBak != null) {
            /**except output [0,0,1]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }


    /**
     * 两链表长度不等,最高位需要连续三次进位
     **/
    @Test
    public void addTwoNumbers4() {
        /**[8,9,9]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(8);
        listNodeBak1.next = new ListNodeBak(9);
        listNodeBak1.next.next = new ListNodeBak(9);

        /**[1]**/
        ListNodeBak listNodeBak2 = new ListNodeBak(2);

        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, listNodeBak2);
        while (resultListNodeBak != null) {
            /**except output [0,0,0,1]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 0, 0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 考虑传入为空列表时
     **/
    @Test
    public void addTwoNumbers5() {
        /**[8,9,9]**/
        ListNodeBak listNodeBak1 = new ListNodeBak(8);
        listNodeBak1.next = new ListNodeBak(9);
        listNodeBak1.next.next = new ListNodeBak(9);


        ListNodeBak resultListNodeBak = ListNodeT002.addTwoNumbersAnswer(listNodeBak1, null);
        while (resultListNodeBak != null) {
            /**except output [8，9,9]**/
            targetList.add(resultListNodeBak.val);
            resultListNodeBak = resultListNodeBak.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{8, 9, 9}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    private boolean varifyListOrder(List<Integer> targetList, List<Integer> exceptList) {
        if (targetList == null && exceptList == null) {
            return true;
        }
        if (targetList != null && exceptList != null &&
                targetList.size() == exceptList.size()) {
            for (int i = 0; i < exceptList.size(); i++) {
                if (exceptList.get(i) != targetList.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}