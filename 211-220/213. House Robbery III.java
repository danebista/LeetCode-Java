class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int maxRobbery= Math.max(linearRobbery(nums,0, nums.length-1),
                                linearRobbery(nums, 1, nums.length));
        return maxRobbery;
    }
    
    public int linearRobbery(int[] nums, int start, int end){
        int prevTwo = 0;
        int prevOne = 0;
        int max = 0;
  
        for (int i=start; i<end; i++){
            max = Math.max(prevTwo+nums[i], prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        
        return max;
    }
}
