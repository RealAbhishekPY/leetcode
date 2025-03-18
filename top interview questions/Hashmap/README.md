### HashMap in Java for Solving DSA Problems

**HashMap** is a part of Java's `java.util` package and provides the functionality of a hash table. It allows storing key-value pairs and provides constant-time performance for basic operations like `get` and `put`.

#### Declaration and Initialization
```java
import java.util.HashMap;

HashMap<Integer, String> map = new HashMap<>();
```

#### Common Operations
- **Put**: `map.put(1, "One");`
- **Get**: `String value = map.get(1);`
- **Remove**: `map.remove(1);`
- **Contains Key**: `boolean hasKey = map.containsKey(1);`
- **Contains Value**: `boolean hasValue = map.containsValue("One");`
- **Iterate**:
  ```java
  for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
  }
  ```

### Example Problem: Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

#### Solution Using HashMap
```java
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: Indices: 0, 1
    }
}
```

### Explanation:
- **HashMap**: Use a HashMap to store the elements of the array along with their indices.
- **Complement**: For each element, calculate the complement (target - current element).
- **Check**: If the complement exists in the HashMap, return the indices of the current element and the complement.
- **Put**: Otherwise, put the current element and its index into the HashMap.

### Example Problem: Find the First Non-Repeating Character in a String
#### Solution Using HashMap
```java
import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static char firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        throw new IllegalArgumentException("No non-repeating character found");
    }

    public static void main(String[] args) {
        String str = "swiss";
        System.out.println("First non-repeating character: " + firstNonRepeatingChar(str)); // Output: w
    }
}
```

### Explanation:
- **HashMap**: Use a HashMap to store the frequency of each character in the string.
- **Frequency Count**: Iterate through the string and update the frequency count in the HashMap.
- **Check**: Iterate through the string again and return the first character with a frequency of 1.

### Benefits of Using HashMap in DSA Problems
- **Efficient Lookups**: Provides constant-time complexity for `get` and `put` operations.
- **Flexibility**: Can store any type of key-value pairs.
- **Handling Duplicates**: Easily manage and count occurrences of elements.
