class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++){
            int minimum = Integer.MAX_VALUE;
            for (int j=1; j*j <=i; j++){
                int remaining = i - j * j;
                if (dp[remaining] < minimum){
                    minimum = dp[remaining];
                }
            }
            
            dp[i] = minimum + 1; 
        }
        
        return dp[n];
    }
}
