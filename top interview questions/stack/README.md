# Stack in Java for Solving DSA Problems

A **stack** is a linear data structure that follows the Last In, First Out (LIFO) principle. It is used in various applications such as expression evaluation, backtracking, and function call management.

#### Declaration and Initialization
In Java, the `Stack` class is part of the `java.util` package.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
```

#### Common Operations
- **Push**: `stack.push(1);` - Adds an element to the top of the stack.
- **Pop**: `int top = stack.pop();` - Removes and returns the top element of the stack.
- **Peek**: `int top = stack.peek();` - Returns the top element without removing it.
- **IsEmpty**: `boolean isEmpty = stack.isEmpty();` - Checks if the stack is empty.

### Example Problem: Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

#### Solution Using Stack
```java
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println("Is valid: " + isValid(s)); // Output: Is valid: true
    }
}
```

### Explanation:
- **Push**: Push opening brackets onto the stack.
- **Pop and Check**: For closing brackets, pop from the stack and check if it matches the corresponding opening bracket.
- **Final Check**: Ensure the stack is empty at the end.

#### Example Problem: Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).

#### Solution Using Stack
```java
import java.util.Stack;

public class EvaluateRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + evalRPN(tokens)); // Output: Result: 9
    }
}
```

### Explanation:
- **Push Numbers**: Push numbers onto the stack.
- **Pop and Evaluate**: For operators, pop the top two numbers, evaluate the result, and push it back onto the stack.
- **Final Result**: The final result is the only element left in the stack.

### Benefits of Using Stack in DSA Problems
- **LIFO Order**: Ideal for problems requiring last-in, first-out processing.
- **Backtracking**: Useful for problems involving backtracking, such as maze solving and recursive algorithms.
- **Expression Evaluation**: Efficient for evaluating expressions and parsing nested structures.
