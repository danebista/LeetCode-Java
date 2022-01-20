class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, top=0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        List<Integer> result = new ArrayList();
        
        
        
        while(left<= right && top<= bottom){
            for (int i=left; i<= right; i++){
                result.add(matrix[top][i]);
            }
            top+=1;
            
            for (int i= top; i<= bottom; i++){
                result.add(matrix[i][right]);
            }
            
            right-=1;
            
            if (!(top<= bottom && left<= right)) break;
            
            for (int i= right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            
            bottom-=1;
            
            for (int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left+=1;
        }
        
        return result;
    }
}
