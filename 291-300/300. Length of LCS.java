class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i< res.length;i++){
            res[i]=1;
        }
        
        int max = 1;
        for (int i=0; i< nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j] && res[i] <= res[j] ){
                     res[i]=res[j]+1;  
                      max = Math.max(max, res[i]);
                }
               
            }
        }
        
        return max;
    }
}
