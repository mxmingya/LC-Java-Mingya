import java.util.*;

class MinStack {

    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (s.size() == 0) {
            s.push(x);
            min.push(x);
            return;
        }
        int cur = min.peek();
        if (x < cur) {
            min.push(x);
        } else {
            min.push(cur);
        }
        s.push(x);
    }
    
    public void pop() {
        if (!s.isEmpty() && !min.isEmpty()) {
            s.pop();
            min.pop();
        }
    }
    
    public int top() {
        if (!s.isEmpty()) {
            return s.peek();
        }
        return Integer.MAX_VALUE;
    }
    
    public int getMin() {
        if (!s.isEmpty() && !min.isEmpty()) {
            return min.peek();
        }
        return Integer.MAX_VALUE;
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