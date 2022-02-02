class Solution {
    public int minCut(String s) {
        int n= s.length();

        boolean[][] dp = new boolean[n][n];
        
        for (int i=n-1; i>=0;i--){
            for (int j=i; j<n; j++){
                if (i==j){
                  dp[i][j] = true;  
                } 
                else if (j-i==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
                else if (s.charAt(i)== s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = false;
                }
            }
            
        }
        int[] totalCuts= new int[n];
        
        for (int j=0; j<n; j++){
            int cut = j;
            for (int i=0; i<=j;i++){
                if (!dp[i][j]) continue;
                cut = Math.min(cut, i==0?0: totalCuts[i-1] +1);
            }
            totalCuts[j] = cut; 
        }
        
        return totalCuts[n-1];
    }
    
}
