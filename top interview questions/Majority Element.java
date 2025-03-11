public class Solution {
    public int majorityElement(int[] num) {
        int count = 0;
        Integer candidate = null;

        for (int n : num) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

