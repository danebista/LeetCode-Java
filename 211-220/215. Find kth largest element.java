class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums,k,0, nums.length-1);
    }
    
    public int quickSelect(int[] nums, int targetIndex, int left, int right){
        int pivot = nums[right];
        int p = left;
        
        for (int i=left; i<right; i++){
            if (nums[i]<=pivot){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p+=1;
            }
        }
        
        int temper = nums[p];
        nums[p] = nums[right];
        nums[right] = temper;
        
        if (p > targetIndex) {
            return quickSelect(nums, targetIndex, left, p-1);
        }
        else if (p < targetIndex){
            return quickSelect(nums, targetIndex,p+1, right);
        }
        else{
            return nums[p];
        }
        
    }
}
