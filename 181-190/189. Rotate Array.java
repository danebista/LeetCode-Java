class Solution {
    public void rotate(int[] nums, int k) {
        k = k % (nums.length);
        reverse(0, nums.length-1, nums);
        reverse(0, k-1, nums);
        reverse(k, nums.length-1, nums);
        
    }
    
    public void reverse(int l, int r, int[]nums){
        while(l<r) swap(l++, r--, nums);
    }
    
    public void swap(int l, int r, int[]nums){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
}
