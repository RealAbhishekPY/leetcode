```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create a frequency map for characters in magazine
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        
        // Check if ransomNote can be constructed using magazine characters
        for (char c : ransomNote.toCharArray()) {
            if (magazineMap.getOrDefault(c, 0) == 0) {
                return false; // Character not available or insufficient count
            }
            magazineMap.put(c, magazineMap.get(c) - 1);
        }
        
        return true; // All characters are available in sufficient count
    }
}
```

### Explanation:
1. **Frequency Map Creation**:
   - Create a `HashMap` to store the frequency of each character in the `magazine` string.
   - Iterate through the `magazine` string and update the frequency map.

2. **Check Construction**:
   - Iterate through the `ransomNote` string.
   - For each character in `ransomNote`, check if it is available in the `magazine` frequency map with a sufficient count.
   - If a character is not available or its count is insufficient, return `false`.
   - Otherwise, decrement the count of the character in the `magazine` frequency map.

3. **Return Result**:
   - If all characters in `ransomNote` are available in sufficient count, return `true`.

### Results:
- For `ransomNote = "a"` and `magazine = "b"`, the output is `false`.
- For `ransomNote = "aa"` and `magazine = "ab"`, the output is `false`.
- For `ransomNote = "aa"` and `magazine = "aab"`, the output is `true`.

This approach runs in O(n) time complexity, where `n` is the length of the `magazine`, and uses O(1) space complexity for the frequency map.

If you have any questions or need further assistance, feel free to ask!
