class Solution {
    public int searchInsert(int[] nums, int target) {
       if (nums.length == 0 || nums == null) return -1;
       if (target<nums[0]) return 0;
       if (target> nums[nums.length-1]) return nums.length;
       int low = 0;
       int high = nums.length;
        
        while(low<=high){
            int midpoint = low + (high - low)/2;
            
            if (nums[midpoint] == target) {
                return midpoint;
             }
            else if (nums[midpoint]< target){
                low = midpoint + 1;
            }
            else {
                high = midpoint - 1;
            }
        }
        
        return low;
    }
}
