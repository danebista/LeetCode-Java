class Solution {
    public int rob(int[] nums) {
       
        int twoPrev = 0;
        int onePrev = 0;
        int max = 0;
        
        for (int i=0; i<nums.length;i++){
            max= Math.max(onePrev, nums[i]+twoPrev);
            twoPrev = onePrev;
            onePrev = max;
        }
        
        return max;
    }
}
