
```java
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            HashMap<String, Integer> seenWords = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;
                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
```

### Explanation:
1. **Initialization**: We initialize the result list and check for edge cases.
2. **Word Map**: We create a `HashMap` to store the frequency of each word in the `words` array.
3. **Sliding Window**: We iterate through the string `s` with a window size equal to the total length of all words combined, but we start at different offsets to cover all possible starting points.
4. **Checking Substrings**: For each starting index, we check if the substring contains all words in the correct frequency using another `HashMap`. We adjust the window size dynamically based on the frequency of words.
5. **Result**: If the substring is valid, we add the starting index to the result list.

This approach ensures that we efficiently find all starting indices of concatenated substrings with a time complexity of \(O(n \times m)\), where \(n\) is the length of the string `s` and \(m\) is the total length of all words combined.
