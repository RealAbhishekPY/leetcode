### Code
```java
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

### Explanation:
- **Stacks**: We use two stacks, `stack` to store all the elements and `minStack` to store the minimum elements.
- **Push**: When pushing a value, we push it onto the `stack`. If the `minStack` is empty or the value is less than or equal to the top of the `minStack`, we also push it onto the `minStack`.
- **Pop**: When popping a value, if the top of the `stack` is equal to the top of the `minStack`, we pop from both stacks.
- **Top**: Simply return the top of the `stack`.
- **GetMin**: Return the top of the `minStack`, which holds the minimum value.

