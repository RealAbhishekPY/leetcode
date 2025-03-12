Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

### **Code**

```java
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[] {left + 1, right + 1}; // Return 1-indexed positions
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {}; // Return an empty array if no solution is found
    }
}
```

### Explanation:
1. **Initialization**:
   - `left` and `right` are pointers initialized to the start and end of the array, respectively.

2. **Two-Pointer Approach**:
   - Use a `while` loop to iterate through the array until the `left` pointer is less than the `right` pointer.
   - Calculate the sum of the elements at the `left` and `right` pointers.
   - If the sum equals the target, return the indices as a 1-indexed array.
   - If the sum is less than the target, increment the `left` pointer to increase the sum.
   - If the sum is greater than the target, decrement the `right` pointer to decrease the sum.

### Results:
- For `numbers = [2, 7, 11, 15]` and `target = 9`, the output is `[1, 2]`.
- For `numbers = [2, 3, 4]` and `target = 6`, the output is `[1, 3]`.
- For `numbers = [-1, 0]` and `target = -1`, the output is `[1, 2]`.

This approach runs in O(n) time complexity and uses O(1) space complexity.
