public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length==0) return 0;
        int i=0;
        int j=0;
        while(i<A.length){
            if(A[i]==elem){
                i++;
            }
            else {
                A[j]=A[i];
                j++;
                i++;
            }
        }
        return j++;
    }
}

