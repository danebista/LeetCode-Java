class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        helper(result, new ArrayList(), k, n, 1);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> current, int k, int n, int index){
        if (k==current.size() && n==0){
            result.add(new ArrayList(current));
            return;
        }
        int prev=-1;
        for (int i=index; i<=9; i++){
            if (i == prev) continue;
            if (i<=n){
                current.add(i);
                helper(result, current,k, n-i, i+1);
                current.remove(new Integer(i));
                prev = i;
            }
        }
    }
}
