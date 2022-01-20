class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList();
        char[][]board = new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<int[]> queens = new ArrayList();
        dfs(board, 0, queens);
        return this.result;
    }
    
    public void dfs(char[][]board, int i, List<int[]>queens){
        if (board.length == queens.size()){
            List<String> rows = new ArrayList();
            for (char [] row: board){
                rows.add(new String(row));
            }
            result.add(rows);
        }
        
        for (int c=0; c< board.length; c++){
            if (canAddQueen(i,c, queens)){
                board[i][c] = 'Q';
                queens.add(new int[]{i,c});
                dfs(board, i+1, queens);
                board[i][c] = '.';
                queens.remove(queens.size()-1);
            }
        }
    
        
    }
    public boolean  canAddQueen(int row, int column, List<int[]> queens){
        for (int[]queen: queens){
            int dx = Math.abs(row-queen[0]);
            int dy = Math.abs(column-queen[1]);
            if (dx == 0 || dy==0 || dx==dy) return false;
        }
        
        return true;
    }
}
