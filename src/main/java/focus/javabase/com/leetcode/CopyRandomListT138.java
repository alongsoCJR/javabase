package focus.javabase.com.leetcode;


//A linked list of length n is given such that each node contains an additional
//random pointer, which could point to any node in the list, or null.
//
// Construct a deep copy of the list. The deep copy should consist of exactly n
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list.
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y.
//
// Return the head of the copied linked list.
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where:
//
//
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node.
//
//
// Your code will only be given the head of the original linked list.
//
//
// Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//
//
// Example 3:
//
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
//
//
//
// Constraints:
//
//
// 0 <= n <= 1000
// -104 <= Node.val <= 104
// Node.random is null or is pointing to some node in the linked list.
//
// Related Topics 哈希表 链表
// 👍 1493 👎 0


import focus.javabase.com.leetcode.base.Node;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
public class CopyRandomListT138 {


    // 题目理解错了
    public static Node copyRandomList(Node head) {
        Node preHead = new Node(-1);
        Node node = preHead;

        while (head != null) {
            node.next = new Node(head.val);
            if (head.random != null) {
                node.next.random = new Node(head.random.val);
            } else {
                node.next.random = null;
            }
            node = node.next;
            head = head.next;
        }
        return preHead.next;
    }


    // 题目理解错了
    public static Node copyRandomList1(Node head) {
        Node preHead = new Node(-1);
        Node node = preHead;

        Map<Node, Integer> getRandomValMap = new HashMap<>();
        Map<Integer, Node> getNodeMap = new HashMap<>();
        int i = 0;
        while (head != null) {
            node.next = new Node(head.val);
            if (head.random != null) {
                getRandomValMap.put(node.next, head.random.val);
            } else {
                getRandomValMap.put(node.next, -1);
            }
            getNodeMap.put(i, node.next);
            node = node.next;
            head = head.next;
            i++;
        }

        node = preHead.next;
        while (node != null) {
            int randomVal = getRandomValMap.get(node);
            Node randomNode = randomVal != -1 ? getNodeMap.get(randomVal) : null;
            node.random = randomNode;
            node = node.next;
        }
        return preHead.next;
    }

}