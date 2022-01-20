class Solution {
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    
    public boolean solver(char[][]board){
        
        int row = -1;
        int column = -1;
        
        for (int i=0; i<9;i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.') {
                     row=i;
                     column = j;
                }
            }
        }
        
        if (row == -1 && column == -1) return true;
        
        for (int i=1; i<10; i++){
            if (validSquare(board, row, column, i)){
                board[row][column] =Character.forDigit(i, 10);
                
                if (solver(board)){
                    return true;
                }
                
                board[row][column] = '.';
            }
        }
        
        return false;
    }
    
    public boolean validAcrossRow(char[][]board, int row, int column, int num){
        for (int i=0; i<9;i++){
            if (board[row][i] !='.' && i!=column && board[row][i]-'0'==num) return false;
        }
        
        return true;
    }
    
    public boolean validAcrossColumn(char[][]board, int row, int column, int num){
        for (int i=0; i<9;i++){
            if (board[i][column] !='.' && i!=row && board[i][column]-'0'==num) return false;
        }
        
        return true;
    }
    
    public boolean validAcrossBox(char[][]board, int row, int column, int num){
        int box_x = row/3;
        int box_y = column/3;
        for (int i=box_x*3; i<box_x*3+3; i++){
            for (int j= box_y *3; j< box_y*3+3; j++){
                if (board[i][j] !='.' && i!= row && j!=column && board[i][j]-'0'==num) return false;   
            }
        }
        
        return true;
    }
    
    public boolean validSquare(char[][]board, int row, int column, int num){
        if (validAcrossRow(board, row, column, num) && validAcrossColumn(board, row, column, num) && validAcrossBox(board, row, column, num)) return true;
        
        return false;
    }
    
}
