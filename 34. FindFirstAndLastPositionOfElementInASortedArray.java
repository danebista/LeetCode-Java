class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]= findStartingIndex(nums, target);
        result[1]= findEndingIndex(nums, target);
        return result;
    }
    
    public int findStartingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while(left <= right){
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target) index = midpoint;
            if (nums[midpoint]>=target){
                right = midpoint -1;
            }
            else{
                left = midpoint +1;
            }
        }
        
        return index;
    }
    
        
    public int findEndingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while(left <= right){
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target) index = midpoint;
            if (nums[midpoint]<=target){
                left = midpoint + 1;
            }
            else{
                right = midpoint - 1;
            }
        }
        
        return index;
    }
}
