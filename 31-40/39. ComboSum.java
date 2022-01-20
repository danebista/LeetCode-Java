class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 ) return null;
        List<List<Integer>> result = new ArrayList();
        
        recurser(result, candidates, 0, target, new ArrayList());
        return result;
    }
    
    public void recurser(List<List<Integer>> result, int[] candidates, int index, int target, List<Integer> current){
        if (target == 0){
            result.add(new ArrayList(current));
            return;
        }
        
        for (int i= index; i< candidates.length; i++){
            if (candidates[i]<=target){
                current.add(candidates[i]);
                recurser(result, candidates, i, target - candidates[i], current);
                current.remove(new Integer(candidates[i]));
            }
        }
    }
}
