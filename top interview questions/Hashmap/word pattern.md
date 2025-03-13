### Code
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (!wordToChar.get(word).equals(c)) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }
}
```
### Function Definition
```java
public boolean isHappy(int n) {
```
This defines a public method named `isHappy` that takes an integer `n` as a parameter and returns a boolean indicating whether `n` is a happy number.

### Set Initialization
```java
Set<Integer> seenNumbers = new HashSet<>();
```
This initializes a `HashSet` named `seenNumbers` to keep track of the numbers we've seen so far. This helps in detecting cycles to avoid infinite loops.

### Loop to Process Digits
```java
while (n != 1 && !seenNumbers.contains(n)) {
    seenNumbers.add(n);
    n = getNext(n);
}
```
This `while` loop continues until `n` becomes 1 or we detect a cycle (i.e., `n` is already in `seenNumbers`).

- **Condition**: The loop runs as long as `n` is not equal to 1 and `n` is not already in `seenNumbers`.
- **Add to Set**: Inside the loop, `n` is added to the `seenNumbers` set.
- **Update `n`**: The value of `n` is updated to the sum of the squares of its digits using the `getNext` method.

### Return Result
```java
return n == 1;
```
After the loop, the function returns `true` if `n` is equal to 1 (indicating that `n` is a happy number). Otherwise, it returns `false`.

### Helper Method
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
This helper method, `getNext`, calculates the sum of the squares of the digits of `n`.

- **Initialize Sum**: `int sum = 0;` initializes the sum to 0.
- **Process Digits**: The `while` loop processes each digit of `n`:
  - `int digit = n % 10;` extracts the last digit of `n`.
  - `sum += digit * digit;` adds the square of the digit to `sum`.
  - `n /= 10;` removes the last digit from `n`.
- **Return Sum**: The method returns the calculated sum.

### Summary
The `isHappy` function uses a `HashSet` to track seen numbers and a helper method to calculate the sum of the squares of the digits. It iterates through the process until it either finds that `n` is a happy number (i.e., `n` becomes 1) or detects a cycle.
