public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        
        int uniqueIndex = 0;
        for (int currentIndex = 1; currentIndex < A.length; currentIndex++) {
            if (A[currentIndex] != A[uniqueIndex]) {
                uniqueIndex++;
                A[uniqueIndex] = A[currentIndex];
            }
        }
        
        return uniqueIndex + 1;
    }
}
