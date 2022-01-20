class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] mat = new int[r][c];
        
        
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                mat[i][j] = matrix[i][j] == '1'? 1:0;
            }
        }
     
        for (int i=0; i< r;i++){
            int[] left= new int[c];
            int[] right= new int[c];
            Stack<Integer> stack = new Stack();
    
            for (int j=0; j<c; j++){
                if (mat[i][j]>=1){
                    if (i!=0){
                    mat[i][j]=mat[i-1][j]+1;
                    }
                } 
                else{
                    mat[i][j] = 0;
                }
                if (stack.isEmpty()){
                    stack.push(j);
                    left[j] = 0;
                }
                else{
                    while(!stack.isEmpty() && mat[i][stack.peek()]>= mat[i][j]) stack.pop();
                    left[j] = stack.isEmpty()?0: stack.peek()+1;
                    stack.push(j);
                }  
            }
            
            while(!stack.isEmpty()) stack.pop();
            
            for (int j=c-1; j>=0; j--){
                if (stack.isEmpty()){
                    stack.push(j);
                    right[j] = c-1;
                }
                else{
                    while(!stack.isEmpty() && mat[i][stack.peek()]>= mat[i][j]) stack.pop();
                    right[j] = stack.isEmpty()?c-1: stack.peek()-1;
                    stack.push(j);
                }  
            }
            
            for (int j=0; j<c; j++){
                max = Math.max(max, mat[i][j] * (right[j]-left[j]+1));
            }
        }
        
        return max;
    }
}
