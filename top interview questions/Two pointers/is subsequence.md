```java
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abc";
        String t1 = "ahbgdc";
        String s2 = "axc";
        String t2 = "ahbgdc";
        
        System.out.println("Is '" + s1 + "' a subsequence of '" + t1 + "'? " + solution.isSubsequence(s1, t1)); // Output: true
        System.out.println("Is '" + s2 + "' a subsequence of '" + t2 + "'? " + solution.isSubsequence(s2, t2)); // Output: false
    }
}
```

### Explanation:
1. **Initialization**:
   - `m` and `n` are the lengths of strings `s` and `t`, respectively.
   - `i` and `j` are pointers initialized to 0.

2. **Two-Pointer Approach**:
   - Use a `while` loop to iterate through both strings until either pointer reaches the end of its respective string.
   - If the characters at the current positions of `i` and `j` match, increment `i`.
   - Always increment `j` to move through `t`.
   - If `i` reaches the end of `s`, it means all characters of `s` have been found in `t` in the correct order, so return `true`.
   - If the loop ends and `i` has not reached the end of `s`, return `false`.

### Results:
- For `s = "abc"` and `t = "ahbgdc"`, the output is `true`.
- For `s = "axc"` and `t = "ahbgdc"`, the output is `false`.

This approach runs in O(n) time complexity, where `n` is the length of `t`, and uses O(1) space complexity.
