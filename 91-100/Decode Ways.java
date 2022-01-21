class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0:1;
        
        for (int i=2; i<=s.length();i++){
            
            int characterAtI = s.charAt(i-1)-'0';
            int characterBeforeI = s.charAt(i-2)-'0';

            if ( characterAtI >=1){
                dp[i] = dp[i-1];
               
            }
            
            if ( characterBeforeI == 1 || (characterBeforeI ==2 && characterAtI < 7)){
                dp[i]+= dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
}
