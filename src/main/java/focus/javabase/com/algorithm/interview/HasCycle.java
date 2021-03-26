package focus.javabase.com.algorithm.interview;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jianrong.Chen
 * @Description ks一面
 * @Date 2021-03-22 15:22
 **/
public class HasCycle {
    public static void main(String[] args) {
        Node node = new Node(2);
        Node root = new Node(1);
        root.next = node;
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = node;
        if (hasCycle(root)) {
            System.out.println("测试成功！");
        } else {
            System.out.println("测试失败！");
        }
    }


    public static boolean hasCycle2(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Set<Node> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.contains(head)) {
                nodeSet.add(head);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}


class Node {

    int value;

    Node next;

    public Node(int value) {
        this.value = value;
    }
}