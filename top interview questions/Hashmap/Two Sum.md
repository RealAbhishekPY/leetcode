```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
            numToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```


### Class Definition
```java
public class Solution {
```
This defines a public class named `Solution`.

### Method Definition
```java
    public int[] twoSum(int[] nums, int target) {
```
This defines a public method named `twoSum` that takes an array of integers `nums` and an integer `target` as parameters. It returns an array of integers.

### HashMap Initialization
```java
        Map<Integer, Integer> numToIndex = new HashMap<>();
```
This initializes a `HashMap` named `numToIndex` that will store the numbers from the array as keys and their corresponding indices as values.

### Loop Through Array
```java
        for (int i = 0; i < nums.length; i++) {
```
This starts a `for` loop that iterates through each element in the `nums` array.

### Calculate Complement
```java
            int complement = target - nums[i];
```
For each element `nums[i]`, it calculates the `complement` which is the value needed to reach the `target` when added to `nums[i]`.

### Check for Complement
```java
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
```
It checks if the `complement` is already in the `numToIndex` map. If it is, it means we have found the two numbers that add up to the `target`. It then returns an array containing the indices of the `complement` and the current element `i`.

### Add Current Number to Map
```java
            numToIndex.put(nums[i], i);
```
If the `complement` is not found in the map, it adds the current number `nums[i]` and its index `i` to the `numToIndex` map.

### No Solution Found
```java
        throw new IllegalArgumentException("No two sum solution");
    }
}
```
If the loop completes without finding a valid pair, it throws an `IllegalArgumentException` indicating that no solution exists.

### Summary
The method uses a `HashMap` to efficiently find two numbers in the array that add up to the target. It does this by storing each number's index as it iterates through the array and checking if the complement of the current number (i.e., `target - nums[i]`) has already been seen.
