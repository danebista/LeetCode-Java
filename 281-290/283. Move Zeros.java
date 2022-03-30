class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n==0 || n==1) return;
        int l = 0;
        int r = 0;
        
        while (r < n){
            if (nums[r]==0){
                r=r+1;
            }
            else{
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l = l+1;
                r = r+1;
            }
        }
    }
}
