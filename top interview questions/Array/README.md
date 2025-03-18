### Arrays in Java for Solving DSA Problems

**Arrays** are fundamental data structures in Java, used to store multiple values of the same type. They are particularly useful in DSA problems for their constant-time access and fixed size.

#### Declaration and Initialization
```java
int[] arr = new int[5]; // Declaration with size
int[] arr = {1, 2, 3, 4, 5}; // Declaration with initialization
```

#### Common Operations
- **Accessing Elements**: `int value = arr[0];`
- **Modifying Elements**: `arr[1] = 10;`
- **Iterating**:
  ```java
  for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
  }
  ```

#### Example Problem: Find the Maximum Element
```java
public class MaxElement {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findMax(arr)); // Output: 5
    }
}
```

### Strings in Java for Solving DSA Problems

**Strings** are sequences of characters and are immutable in Java. They are widely used in DSA problems involving text processing.

#### Declaration and Initialization
```java
String str = "Hello, World!";
```

#### Common Operations
- **Length**: `int len = str.length();`
- **Character Access**: `char ch = str.charAt(0);`
- **Substring**: `String sub = str.substring(1, 5);`
- **Concatenation**: `String newStr = str + " How are you?";`

#### Example Problem: Check if a String is a Palindrome
```java
public class Palindrome {
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str)); // Output: true
    }
}
```

### Approaches to Solve DSA Problems Using Arrays and Strings

1. **Brute Force**: Start with a straightforward approach, even if it's not the most efficient.
2. **Two-Pointer Technique**: Useful for problems involving arrays or strings where you need to compare elements from both ends.
3. **Sliding Window**: Efficient for problems involving subarrays or substrings.
4. **Hashing**: Use hash maps or sets to store and quickly retrieve elements.
5. **Sorting**: Sort the array or string to simplify the problem.
6. **Dynamic Programming**: Store intermediate results to avoid redundant calculations.

### Example Problem: Longest Substring Without Repeating Characters
```java
import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str)); // Output: 3
    }
}
```

