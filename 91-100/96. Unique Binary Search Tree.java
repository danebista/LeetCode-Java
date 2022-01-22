class Solution {
    public int numTrees(int n) {
        int [] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        
        for (int i=2; i<=n ; i++){
            int total = 0;
            
            for (int j=1; j<=i; j++){
                int l = j-1;
                int r = i-j;
                total += cache[l] * cache[r];
            }
            
            cache[i] = total;
        }
        
        return cache[n];
    }
}
