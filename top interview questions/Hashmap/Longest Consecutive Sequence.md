``` java 
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int longestStreak = 0;

        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                int left = numMap.getOrDefault(num - 1, 0);
                int right = numMap.getOrDefault(num + 1, 0);
                int currentStreak = left + right + 1;

                numMap.put(num, currentStreak);
                numMap.put(num - left, currentStreak);
                numMap.put(num + right, currentStreak);

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
```
