package focus.javabase.com.leetcode;

//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time.
//
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
//
//
//
// Example 1:
//
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks.
//
// Related Topics 栈 设计
//Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(x);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// 栈结构：push、pop、peek    栈顶{a,b,c,d}栈底
// 队列：offer、poll、peek    队头{a,b,c,d}队尾
public class MinStackT155 {
    List<Integer> list = null;
    List<Integer> minList = null;
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStackT155() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        if (minList.size() == 0) {
            min = x;
        } else {
            min = Integer.min(minList.get(minList.size() - 1), x);
        }
        minList.add(min);
    }

    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minList.get(list.size() - 1);
    }

    public static void main(String[] args) {
        MinStackT155 minStack = new MinStackT155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin();
    }
}

// getMin方法时间复杂度为 O(n)
class MinStack {
    LinkedList<Integer> list = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.push(x);
    }

    public void pop() {
        list.pop();

    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            min = Integer.min(min, num);
        }
        return min;
    }
}