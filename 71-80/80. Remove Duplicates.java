class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0 ;
        int index=0;
        for (int i=0; i<nums.length;i++){
            if (count<2){
                nums[index] = nums[i];
                count++;
                index++;
            }
            
            if (i+1 < nums.length && nums[i]!=nums[i+1]) count =0;
        }
        
        return index;
    }
}
              