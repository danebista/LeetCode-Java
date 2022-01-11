class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        
        for (int i=0; i< nums.length-2;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int low =i+1;
            int high = nums.length-1;
            while(low<high){
                int value = nums[i]+nums[low]+nums[high];
                if (value == target){
                    return target;
                }
                
                else if(value<target){
                    low++;
                }
                else{
                    high--;
                }
                
                if (Math.abs(value-target)<Math.abs(result-target)){
                    result = value;
                }
            }
            
        }
        
        return result;
        
    }
}
