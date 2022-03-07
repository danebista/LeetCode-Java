public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs.length==0) return 0;
        int[][] dp = new int[costs.length][costs[0].length];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for (int j=0; j< costs[0].length; j++){
            dp[0][j] = costs[0][j];
            if (dp[0][j] <= least){
                sleast = least;
                least = dp[0][j];
            }
            else if (dp[0][j]< sleast){
                sleast = dp[0][j];
            }
        }
      
        for (int i=1; i < dp.length; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j=0; j<dp[0].length; j++){
               dp[i][j] = costs[i][j] + (dp[i-1][j]==least?sleast:least);
               if (dp[i][j] <= nleast){
                nsleast = nleast;
                nleast = dp[i][j];
                }
                else if (dp[i][j]< nsleast){
                  nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        return least;
    }
}
