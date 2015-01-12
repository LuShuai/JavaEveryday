package datastructure;

import java.util.Stack;

class MinStack {
    Stack<Integer> nums = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    
    public void push(int x) {
        if ( mins.empty() || x <= mins.peek() ) {
            mins.push(x);
        }
        nums.push(x);
    }

    public void pop() {
    	System.out.println("MINS PEEK:" + mins.peek());
    	System.out.println("NUMS PEEK:" + nums.peek());
        if (!mins.empty() && mins.peek().intValue() == nums.peek().intValue()) {
        	
            mins.pop();
        }
        nums.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
