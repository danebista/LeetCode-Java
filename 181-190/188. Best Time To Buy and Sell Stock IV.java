class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n<=1 || k==0) return 0;
        
        if (2*k>=n){
            int res=0;
            for (int i=1; i<n; i++){
                if (prices[i]>prices[i-1]) res+= prices[i]- prices[i-1];
            }
            return res;
        }
        
        int[] dp = new int[2*k];
        
        for (int j=0; j<2*k; j++){
            if (j%2==0) {
                dp[j] = Integer.MIN_VALUE;
            }
            else{
                dp[j] = 0;
            }
        }
        
        for (int i=0; i<n;i++){
            for(int j=0; j<2*k ; j++){
                if (j==0){
                    dp[j] = Math.max(dp[j],-prices[i]);
                }
                else if (j%2==0){
                    dp[j] = Math.max(dp[j], dp[j-1]-prices[i]);
                }
                else{
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[i]);
                }
            }
        }
        
        return dp[2*k-1];
        
    }
}