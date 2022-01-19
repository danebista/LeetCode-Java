class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        for (int i=0; i<rows;i++){
            for (int j=0; j<columns;j++){
                if (word.charAt(0) == board[i][j] && helper(word, board,0,  i, j)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(String word, char[][]board,int index, int i, int j){
        if (index==word.length()) return true;
        if (i<0 || i>=board.length || j<0 || j>= board[0].length || word.charAt(index)!=
           board[i][j] || visited[i][j]) return false;
        
        visited[i][j] = true;
        if (helper(word, board,index+1, i+1, j) || helper(word,board,index+1, i-1,j)
            || helper(word, board, index+1,i, j+1) || helper(word, board,index+1, i, j-1)
           ) return true;
        visited[i][j] = false;
        return false;
    }
}
