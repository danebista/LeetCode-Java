class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0]=1;
        int f = 1;
        for (int i=1; i<n; i++){
            f=f*i;
            fact[i] = f; 
        }
        
        List<Integer> digits = new ArrayList();
        for (int i=1; i<=n; i++){
            digits.add(i);
        }
        StringBuilder res = new StringBuilder();
        
        helper(res, fact, digits, n, k);
        return res.toString();
    }
    
    public void helper(StringBuilder res, int[]fact, List<Integer> digits, int n, int k){
        if (n==1){
            res.append(digits.get(0));
            return;
        }
        
        int index = k/fact[n-1];
        
        if (k % fact[n-1] == 0){
            index-=1;
        }
        res.append(digits.get(index));
        digits.remove(index);
        k-=fact[n-1] * index;
        helper(res, fact, digits, n-1, k);
    }
}
