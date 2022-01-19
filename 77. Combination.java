class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        helper(result, new ArrayList(), 1, k, n);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> current, int i , int k, int n){
        if (current.size() == k){
            result.add(new ArrayList(current));
            return;
        }
        
        for (int m=i; m<=n; m++){
            current.add(m);
            helper(result, current, m+1, k, n);
            current.remove(current.size()-1);
        }
    }
}
