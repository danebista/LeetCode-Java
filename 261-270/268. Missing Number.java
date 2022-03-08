class Solution {
    public int missingNumber(int[] nums) {
        boolean seen1=false;
        for (int i=0; i< nums.length; i++){
            if (nums[i]==1) seen1=true;
            if (nums[i]<=0 || nums[i]>nums.length) nums[i]=1;
        }
        if (!seen1) return 1;
        
        for (int i=0; i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if (nums[index]>0) nums[index]=-1 * nums[index];
        }
        
        for (int i=0; i<nums.length;i++){
            if (nums[i]>0) return i+1;
        }
        return 0;
    }
}
