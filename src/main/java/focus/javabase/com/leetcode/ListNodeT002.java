package focus.javabase.com.leetcode;

/*
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 还要求可以进位
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
*/

/**
 * @author chenjianrong-lhq 2019年07月12日 22:45:24
 * *
 * * Definition for singly-linked list.
 * * public class ListNodeBak {
 * *     int val;
 * *     ListNodeBak next;
 * *     ListNodeBak(int x) { val = x; }
 * * }
 * *step1: 拆解[7 ->10 ->7]  step2:[8 ->0 -> 7] 之后再反转 得到 [7 -> 0 -> 8]
 * question1: 单链表的反转
 * question2: 需不需要递归，感觉递归加大了算法的难度。记住：能用递归的地方，都能用迭代。
 * question3: 还记得当时面试做的大整数加法吗？
 */
public class ListNodeT002 {

    public static ListNodeBak addTwoNumbers(ListNodeBak listNodeBak1, ListNodeBak listNodeBak2) {
        ListNodeBak tempNode = null;
        ListNodeBak prevNode = null;
        ListNodeBak headNode = null;
        int val1 = 0;
        int val2 = 0;
        int val = 0;
        int increment = 0;
        boolean flag = false;
        while (listNodeBak1 != null && listNodeBak2 != null) {
            val1 = listNodeBak1.val;
            val2 = listNodeBak2.val;
            if (val1 + val2 >= 10) {
                val = (val1 + val2) % 10;
                increment = (val1 + val2) / 10;
            } else {
                val = val1 + val2;
            }
            if (flag) {
                tempNode = new ListNodeBak(val + increment);
                increment = 0;
                flag = false;
            } else {
                tempNode = new ListNodeBak(val);
            }
            /**第一波优化，无需反转**/
            if (listNodeBak1.next == null && listNodeBak2.next == null) {
                headNode = tempNode;
            }

            tempNode.next = prevNode;
            prevNode = tempNode;
            listNodeBak1 = listNodeBak1.next;
            listNodeBak2 = listNodeBak2.next;
            if (increment != 0) {
                flag = true;
            }
        }

        if (flag) {
            tempNode = new ListNodeBak(increment);
            tempNode.next = prevNode;
            headNode = tempNode;
        }
        return reverse(headNode);
    }


    /**
     * 考虑到位数不同的情况，应该先对原链表进行反转
     **/
    public static ListNodeBak addTwoNumbersOptimize(ListNodeBak listNodeBak1, ListNodeBak listNodeBak2) {
        ListNodeBak tempNode = null;
        ListNodeBak prevNode = null;
        ListNodeBak headNode = null;
        int val1 = 0;
        int val2 = 0;
        int val = 0;
        int increment = 0;
        boolean flag = false;
        while (listNodeBak1 != null && listNodeBak2 != null) {
            val1 = listNodeBak1.val;
            val2 = listNodeBak2.val;
            if (val1 + val2 >= 10) {
                val = (val1 + val2) % 10;
                increment = (val1 + val2) / 10;
            } else {
                val = val1 + val2;
            }
            if (flag) {
                tempNode = new ListNodeBak(val + increment);
                increment = 0;
                flag = false;
            } else {
                tempNode = new ListNodeBak(val);
            }
            if (listNodeBak1.next == null && listNodeBak2.next == null) {
                headNode = tempNode;
            }

            if (listNodeBak1.next == null && listNodeBak2.next != null) {
                listNodeBak1.next = new ListNodeBak(0);
            }

            if (listNodeBak1.next != null && listNodeBak2.next == null) {
                listNodeBak2.next = new ListNodeBak(0);
            }
            tempNode.next = prevNode;
            prevNode = tempNode;
            listNodeBak1 = listNodeBak1.next;
            listNodeBak2 = listNodeBak2.next;
            if (increment != 0) {
                flag = true;
            }
        }

        if (flag) {
            tempNode = new ListNodeBak(increment);
            tempNode.next = prevNode;
            headNode = tempNode;
        }
        return reverse(headNode);
    }

    /**
     * 连续进位
     **/
    public static ListNodeBak addTwoNumbersCarryBit(ListNodeBak listNodeBak1, ListNodeBak listNodeBak2) {
        ListNodeBak tempNode = null;
        ListNodeBak prevNode = null;
        ListNodeBak headNode = null;
        int val1 = 0;
        int val2 = 0;
        int val = 0;
        int increment = 0;
        int tempVal = 0;
        boolean flag = false;
        while (listNodeBak1 != null && listNodeBak2 != null) {
            val1 = listNodeBak1.val;
            val2 = listNodeBak2.val;
            if (val1 + val2 >= 10) {
                val = (val1 + val2) % 10;
                increment = (val1 + val2) / 10;
            } else {
                val = val1 + val2;
            }
            if (flag) {
                tempNode = new ListNodeBak(val + increment);
                increment = 0;
                flag = false;
            } else {
                tempNode = new ListNodeBak(val);
            }

            if (tempNode.val >= 10) {
                increment = 1;
                flag = true;
            }
            if (listNodeBak1.next == null && listNodeBak2.next == null) {
                headNode = tempNode;
            }

            if (listNodeBak1.next == null && listNodeBak2.next != null) {
                listNodeBak1.next = new ListNodeBak(0);
            }

            if (listNodeBak1.next != null && listNodeBak2.next == null) {
                listNodeBak2.next = new ListNodeBak(0);
            }

            tempVal = tempNode.val;
            if (tempVal < 10) {
                tempNode.next = prevNode;
                prevNode = tempNode;
            }

            listNodeBak1 = listNodeBak1.next;
            listNodeBak2 = listNodeBak2.next;
            if (increment != 0) {
                flag = true;
            }
        }

        if (flag && tempVal < 10) {
            tempNode = new ListNodeBak(increment);
            tempNode.next = prevNode;
            headNode = tempNode;
        }

        if (tempVal >= 10) {
            tempNode = new ListNodeBak(1);
            tempVal = tempVal % 10;
            tempNode.next = new ListNodeBak(tempVal);
            tempNode.next.next = prevNode;
            headNode = tempNode;
        }

        return reverse(headNode);
    }


    /**
     * 位数不等，连续进位
     **/
    public static ListNodeBak addTwoNumbersContinueCarryBit(ListNodeBak listNodeBak1, ListNodeBak listNodeBak2) {
        ListNodeBak tempNode = null;
        ListNodeBak prevNode = null;
        ListNodeBak headNode = null;
        ListNodeBak bitNode = null;
        if (listNodeBak1 == null) {
            return listNodeBak2;
        }
        if (listNodeBak2 == null) {
            return listNodeBak1;
        }
        while (listNodeBak1 != null && listNodeBak2 != null) {
            tempNode = new ListNodeBak(listNodeBak1.val + listNodeBak2.val);
            if (prevNode != null && prevNode.val >= 10) {
                int val = prevNode.val / 10;
                tempNode = new ListNodeBak(val + listNodeBak1.val + listNodeBak2.val);
                prevNode.val = bitNode.val;
            }
            if (listNodeBak1.next == null && listNodeBak2.next == null) {
                headNode = tempNode;
                break;
            }

            if (listNodeBak1.next == null && listNodeBak2.next != null) {
                listNodeBak1.next = new ListNodeBak(0);
            }

            if (listNodeBak1.next != null && listNodeBak2.next == null) {
                listNodeBak2.next = new ListNodeBak(0);
            }
            tempNode.next = prevNode;
            prevNode = tempNode;
            if (tempNode.val >= 10) {
                bitNode = new ListNodeBak(tempNode.val % 10);
            }
            listNodeBak1 = listNodeBak1.next;
            listNodeBak2 = listNodeBak2.next;
        }

        if (tempNode.val >= 10) {
            headNode = new ListNodeBak(1);
            headNode.next = new ListNodeBak(tempNode.val % 10);
            headNode.next.next = prevNode;
        } else {
            tempNode.next = prevNode;
        }
        return reverse(headNode);
    }

    /**
     * @return focus.javabase.com.leetcode.ListNodeBak
     * @Author chenjianrong-lhq
     * @Description 单链表的反转
     * @Date 2019-07-13 21:35
     * @Param [listNode]
     **/
    public static ListNodeBak reverse(ListNodeBak head) {
        ListNodeBak reverseHead = head;
        ListNodeBak prevNode = null;
        ListNodeBak nextNode = null;
        while (head != null) {
            nextNode = head.next;
            if (head.next == null) {
                reverseHead = head;
            }
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return reverseHead;
    }


    /**
     * 标准答案,无需反转
     **/
    public static ListNodeBak addTwoNumbersAnswer(ListNodeBak listNodeBak1, ListNodeBak listNodeBak2) {
        ListNodeBak p = listNodeBak1, q = listNodeBak2;
        /**这个设计得巧妙，成功避开反转,利用哑节点记录起始相加节点的位置**/
        ListNodeBak headNode = new ListNodeBak(0);
        int carry = 0, sum = 0;
        ListNodeBak curr = headNode;
        while (p != null || q != null) {
            int pVal = (p == null) ? 0 : p.val;
            int qVal = (q == null) ? 0 : q.val;
            sum = carry + pVal + qVal;
            carry = sum / 10;
            curr.next = new ListNodeBak(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNodeBak(carry);
        }

        return headNode.next;
    }

}


class ListNodeBak {
    int val;
    ListNodeBak next;

    ListNodeBak(int x) {
        val = x;
    }
}
