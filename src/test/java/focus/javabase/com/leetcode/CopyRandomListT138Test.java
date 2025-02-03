package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CopyRandomListT138Test extends AbstractTest {

    //Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//
    @Before
    public void setUp() throws Exception {

        Node a = new Node(7); // 0
        Node b = new Node(13);  // 1
        Node c = new Node(11);  // 2
        Node d = new Node(10);  // 3
        Node e = new Node(1);   // 4

        inputNode = a;
        inputNode.random = null;
        inputNode.next = b;
        inputNode.next.random = a;
        inputNode.next.next = c;
        inputNode.next.next.random = e;
        inputNode.next.next.next = d;
        inputNode.next.next.next.random = c;
        inputNode.next.next.next.next = e;
        inputNode.next.next.next.next.random = a;
    }

    @Test
    public void copyRandom() {
        outputNode = CopyRandomListT138.copyRandomList(inputNode);
    }

    @Test
    public void copyRandom1() {
        outputNode = CopyRandomListT138.copyRandomList1(inputNode);
    }
}