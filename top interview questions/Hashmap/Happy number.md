```java
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
```

### Explanation

1. **Class Definition**:
   ```java
   public class Solution {
   ```
   This defines a public class named `Solution`.

2. **Method Definition**:
   ```java
   public boolean isHappy(int n) {
   ```
   This defines a public method named `isHappy` that takes an integer `n` as a parameter and returns a boolean indicating whether `n` is a happy number.

3. **Set Initialization**:
   ```java
   Set<Integer> seenNumbers = new HashSet<>();
   ```
   This initializes a `HashSet` named `seenNumbers` to keep track of the numbers we've seen so far to detect cycles.

4. **Loop to Process Digits**:
   ```java
   while (n != 1 && !seenNumbers.contains(n)) {
       seenNumbers.add(n);
       n = getNext(n);
   }
   ```
   This loop continues until `n` becomes 1 or we detect a cycle (i.e., `n` is already in `seenNumbers`). Inside the loop, we add `n` to `seenNumbers` and update `n` to the sum of the squares of its digits using the `getNext` method.

5. **Return Result**:
   ```java
   return n == 1;
   ```
   If `n` becomes 1, the method returns `true`, indicating that `n` is a happy number. Otherwise, it returns `false`.

6. **Helper Method**:
   ```java
   private int getNext(int n) {
       int sum = 0;
       while (n > 0) {
           int digit = n % 10;
           sum += digit * digit;
           n /= 10;
       }
       return sum;
   }
   ```
   This helper method calculates the sum of the squares of the digits of `n`.
