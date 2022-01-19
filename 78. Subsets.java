class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        helper(result, new ArrayList(), nums,0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> current, int[] nums, int i){
        result.add(new ArrayList(current));
        
        for (int index=i; index< nums.length; index++){
            current.add(nums[index]);
            helper(result, current, nums, index+1);
            current.remove(current.size()-1);
        }
    }
}
