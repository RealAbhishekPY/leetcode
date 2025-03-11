public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int idx = 1; // Start from the second element
        int count = 1; // Count occurrences of the current element

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                A[idx++] = A[i];
            }
        }

        return idx;
    }
}

