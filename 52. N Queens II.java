class Solution {
    int result;
    public int totalNQueens(int n) {
        this.result = 0;
        char[][] board = new char[n][n];
        List<int[]> queens = new ArrayList();
        
        helper(board, 0, queens);
        
        return this.result;
    }
    
    public void helper(char[][]board, int i, List<int[]> queens){
        if (queens.size() == board.length){
            this.result+=1;
            return;
        }
        
        for (int r=0; r< board.length; r++){
            if (validSquare(i,r, queens)){
                board[i][r] = 'Q';
                queens.add(new int[]{i,r});
                helper(board, i+1, queens);
                board[i][r] = '.';
                queens.remove(queens.size()-1);
            }
        }
    }
    
    public boolean validSquare(int row, int column, List<int[]> queens){
        for (int[] queen: queens){
            int dx = Math.abs(row- queen[0]);
            int dy = Math.abs(column - queen[1]);
            
            if (dx == 0 || dy == 0 || dx == dy){
                return false;
            }
        }
        
        return true;
    }
}
