
```java
import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, n = s.length();
        
        for (int l = 0, r = 0; r < n; ++r) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(map.get(c) + 1, l);
            }
            map.put(c, r);
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
}
```

### Explanation:
1. **Initialization**: We use a `HashMap` to store the characters and their latest indices.
2. **Expanding the Window**: We iterate through the string with the `right` pointer (`r`).
3. **Updating the Left Pointer**: If the character at `right` (`c`) is already in the map, we update the `left` pointer (`l`) to be the maximum of its current value or the index after the last occurrence of `c`.
4. **Updating the Map**: We update the map with the current character and its index.
5. **Calculating the Answer**: We update `ans` with the maximum length of the substring found so far.

This approach ensures that each character is processed in constant time, resulting in a linear time complexity of \(O(n)\). The space complexity is reduced to \(O(n)\) due to the use of the `HashMap`.
