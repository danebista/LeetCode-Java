class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int a_poi=0;
        int res = Integer.MAX_VALUE;
        int val_sum = 0;
        for (int i=0; i < nums.length; i++){
            val_sum+=nums[i];
            
            while(val_sum>= target){
                res = Math.min(res, i+1-a_poi);
                val_sum -= nums[a_poi];
                a_poi++;
            }
            
        }
        
        return res==Integer.MAX_VALUE?0: res;
    }
}
