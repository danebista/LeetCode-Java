class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        
        return fibonacci(n);
        
    }
    
    public int fibonacci(int n){
        if (n==0 || n==1) {
            cache[n] = 1;
            return cache[n];
        } 
        
        if (cache[n] != 0) return cache[n];
        
        cache[n] = fibonacci(n-1) + fibonacci(n-2);
        
        return cache[n];
    }
}
