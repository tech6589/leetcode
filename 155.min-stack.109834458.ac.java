/*
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack
 *
 * algorithms
 * Easy (29.11%)
 * Total Accepted:    146.4K
 * Total Submissions: 502.9K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
public class MinStack {
    private List<Element> l;
    /** initialize your data structure here. */
    public MinStack() {
        l=new LinkedList<>();
    }
    
    public void push(int x) {
        int size=l.size();
        if(size==0){
            l.add(new Element(x, x));
        }else{
            l.add(new Element(x, Math.min(x, l.get(size-1).min)));
        }
    }
    
    public void pop() {
        l.remove(l.size()-1);
    }
    
    public int top() {
        return l.get(l.size()-1).val;
    }
    
    public int getMin() {
        return l.get(l.size()-1).min;
    }
    private class Element{
        int val;
        int min;//this min is the minimum value from the bottom of stack to current Element.
        public Element(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
