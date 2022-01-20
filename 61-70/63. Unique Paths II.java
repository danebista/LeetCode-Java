class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int [obstacleGrid.length][obstacleGrid[0].length];
        
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1
           || obstacleGrid[0][0]==1) return 0;
        
        for (int i=obstacleGrid.length-1; i>=0; i--){
            for (int j=obstacleGrid[0].length-1; j>=0; j--){
                if (i ==obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
                    dp[i][j] = 1;
                }
                else if(i==obstacleGrid.length-1){
                   if (obstacleGrid[i][j] == 0){
                       dp[i][j] =1;
                       if (dp[i][j+1] == 0) dp[i][j] = 0;
                   }
                   else{
                       dp[i][j] = 0;
                   }
                }
                else if (j == obstacleGrid[0].length-1){
                    if (obstacleGrid[i][j] == 0 ){
                        dp[i][j]=1;
                        if (dp[i+1][j]==0) dp[i][j] =0;
                    }
                    else{
                        dp[i][j]=0;
                    }
                }
                
                else{
                    if(obstacleGrid[i][j] ==1){
                       dp[i][j] = 0; 
                    }
                    else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                    }
                }
            }
        }
        return dp[0][0];
        
    }
}
