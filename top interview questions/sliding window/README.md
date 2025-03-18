# Sliding Window Technique in Java for Solving DSA Problems

The **sliding window technique** is a powerful method for solving problems involving subarrays or substrings. It involves maintaining a window that slides over the data structure to find the desired result efficiently.

#### Example Problem: Maximum Sum Subarray of Size K
Given an array of integers and an integer K, find the maximum sum of any subarray of size K.

#### Solution Using Sliding Window
```java
public class MaxSumSubarray {
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSumSubarray(nums, k)); // Output: 24
    }
}
```

### Explanation:
- **Initial Window**: Calculate the sum of the first window of size K.
- **Slide the Window**: Slide the window by adding the next element and removing the first element of the previous window.
- **Update Maximum**: Update the maximum sum if the current window sum is greater.

#### Example Problem: Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

#### Solution Using Sliding Window
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
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(str)); // Output: 3
    }
}
```

### Explanation:
- **HashSet**: Use a HashSet to store characters of the current window.
- **Slide the Window**: Slide the window by removing characters from the left until there are no repeating characters.
- **Update Maximum**: Update the maximum length if the current window length is greater.

#### Example Problem: Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T.

#### Solution Using Sliding Window
```java
import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        int required = mapT.size();
        int left = 0, right = 0, formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if (mapT.containsKey(c) && windowCounts.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (mapT.containsKey(c) && windowCounts.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t)); // Output: "BANC"
    }
}
```

### Explanation:
- **HashMap**: Use a HashMap to store the frequency of characters in T.
- **Slide the Window**: Slide the window by expanding the right pointer and contracting the left pointer to find the minimum window.
- **Update Result**: Update the result if the current window is smaller.

### Benefits of Sliding Window Technique
- **Efficiency**: Reduces time complexity by avoiding nested loops.
- **Simplicity**: Easy to implement and understand.
- **Versatility**: Applicable to a wide range of problems involving subarrays and substrings.
