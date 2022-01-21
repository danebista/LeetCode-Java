class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        
        helper(nums, 0, result, new ArrayList());
        return result;
    }
    
    public void helper(int[]nums, int index, List<List<Integer>> result, List<Integer>current){
        result.add(new ArrayList(current));
        
        int prev = -1000;
        
        for (int i=index; i<nums.length; i++){
            if (prev == nums[i]) continue;
            
            current.add(nums[i]);
            helper(nums, i+1, result, current);
            current.remove(current.size()-1);
            prev = nums[i];
        }
    }
}
