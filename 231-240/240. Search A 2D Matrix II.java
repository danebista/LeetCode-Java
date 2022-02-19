class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) return false;
        int i=0;
        int j=matrix[0].length-1;
        if (matrix.length==1 && matrix[0].length==1) return target==matrix[0][0];
        while (true){
            if(i>=matrix.length || j< 0) return false;
            
            if (matrix[i][j] == target) return true;
            
            else if (matrix[i][j]> target){
                j--;
            }
            else{
                i++;
            }
        }
    }
}
