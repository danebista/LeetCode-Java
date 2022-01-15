class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        helper(result, new ArrayList(), new boolean[nums.length], nums);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> curr, boolean[] used, int[]nums){
        if (curr.size()==nums.length){
            result.add(new ArrayList(curr));
            return;
        }
        int prev = -100000;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==prev) continue;
            if (used[i]) continue;
            used[i]=true;
            curr.add(nums[i]);
            helper(result, curr, used, nums);
            used[i]=false;
            curr.remove(curr.size()-1);
            prev = nums[i];
        }
    }
}
