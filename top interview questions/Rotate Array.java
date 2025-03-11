public class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if(l<=0) return;
        k=k%l;
        if(k<=0) return;
        int a =l-k;
        reverse(nums,0,a-1);
        reverse(nums,a,l-1);
        reverse(nums,0,l-1);
    }
    public void reverse(int[] nums,int left,int right){
        if(nums==null||nums.length==1){
            return;
        }
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}

