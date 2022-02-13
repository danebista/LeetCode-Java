class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length==0 || grid==null){
            return 0;
        }
        int res = 0;
        for (int i=0; i< grid.length; i++){
            for (int j=0; j< grid[0].length; j++){
                res+= helper(i,j, grid);
            }
        }
        
        return res;
        
    }
    
    public int helper(int i, int j, char [][] grid){
        if (i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {
            return 0;
        }
        
        grid[i][j]='0';
        helper(i-1, j , grid);
        helper(i+1, j , grid);
        helper(i, j-1, grid);
        helper(i, j+1, grid);
        
        return 1;
    }
}
