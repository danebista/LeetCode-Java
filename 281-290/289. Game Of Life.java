class Solution {
    public void gameOfLife(int[][] board) {
        int m =  board.length;
        int n = board[0].length;
        
        int[][] copyArray = new int[m][n];
        
        int[][] deck = new int[][]{
            {-1,0},
            {-1, 1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1}
        };
        
        
        for (int i=0; i< m; i++){
            for (int j=0; j<n; j++){
                int liveCount =0;
                
                for (int[]dr: deck){
                    int x_grad = dr[0] + i;
                    int y_grad = dr[1] + j;
                    
                    if (x_grad>=0 && x_grad<m && y_grad>=0 && y_grad<n && board[x_grad][y_grad]==1) liveCount++;
                    
                }
                
                if (board[i][j]==0 && liveCount==3) copyArray[i][j] = 1;
                if (board[i][j]==1 && (liveCount==2 || liveCount==3)) copyArray[i][j]=1;
            }
        }
        
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                board[i][j] = copyArray[i][j];
            }
        }
        
    }
}
