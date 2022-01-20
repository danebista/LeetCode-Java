class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hashSet = new HashSet();
        
        for (int i=0; i< 9; i++){
            for (int j=0; j<9; j++){
                char current_val = board[i][j];
                if (current_val != '.'){
                    if (!hashSet.add(current_val+"row"+i) 
                        || !hashSet.add(current_val+"column"+j)
                        || !hashSet.add(current_val+"board"+i/3+"-"+j/3)) return false;
                }
            }
        }
        
        return true;
    }
}
