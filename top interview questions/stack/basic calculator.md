I see the issue. The current implementation does not handle nested parentheses correctly. Let's update the code to properly handle nested parentheses by using a stack to keep track of the current result and sign when encountering parentheses.

Here's the updated Java code:

```java

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the current result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                // Pop the sign and result from the stack
                result *= stack.pop(); // This is the sign before the parenthesis
                result += stack.pop(); // This is the result calculated before the parenthesis
            }
        }
        // Add the last number to the result
        result += sign * num;
        return result;
    }
}
```

### Explanation:
1. **Initialization**:
   - Use a `Stack` to keep track of the current result and sign when encountering parentheses.
   - Initialize `num` to build numbers, `result` to store the current result, and `sign` to keep track of the current sign (1 for positive, -1 for negative).

2. **Iteration**:
   - Iterate through the string `s`.
   - If the character is a digit, build the number by multiplying `num` by 10 and adding the digit.
   - If the character is a `+` or `-`, update the `result` with the current `num` and `sign`, then reset `num` and update `sign`.
   - If the character is a `(`, push the current `result` and `sign` onto the stack, then reset `result` and `sign` for the new sub-expression.
   - If the character is a `)`, update the `result` with the current `num` and `sign`, then pop the sign and result from the stack and update the `result`.

3. **Final Calculation**:
   - Add the last number to the `result`.

This updated approach correctly handles nested parentheses and ensures the expression is evaluated correctly.
