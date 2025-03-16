``` java
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            
            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
```
Explanation:
Initialization: We initialize minLen to Integer.MAX_VALUE, left to 0, and sum to 0.
Expanding the Window: We iterate through the array with the right pointer, adding nums[right] to sum.
Shrinking the Window: Whenever sum is greater than or equal to s, we update minLen and subtract nums[left] from sum, then increment left to shrink the window.
Result: If minLen remains Integer.MAX_VALUE, it means no valid subarray was found, so we return 0. Otherwise, we return minLen.
This approach ensures that each element (once by the right pointer and once by the left pointer), resulting in a linear time complexity of 
O
(
n
)
O(n).
