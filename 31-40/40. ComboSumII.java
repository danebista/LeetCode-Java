class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        recurser(candidates, 0, target, new ArrayList(), result );
        return result;
    }
    
    public void recurser(int[] candidates, int index, int target, List<Integer> current,List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList(current));
            return;
        }
        int prev = -1;
        for (int i= index; i< candidates.length; i++){
            if (i> 0 &&  candidates[i] == prev) continue;
            if (candidates[i]<=target){
                current.add(candidates[i]);
                recurser(candidates, i+1, target-candidates[i], current, result);
                current.remove(new Integer(candidates[i]));
                prev = candidates[i];
            }
        }
    }
}
