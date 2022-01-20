/* when last element of matrix != first elemnt of neext row */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j = matrix[0].length-1;
        int pointer = matrix[0][matrix[0].length-1];
        while(i< matrix.length && j>=0){
            if (matrix[i][j]== target) return true;
            
            if (matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        
        return false;
    }
}

/* Fully sorted matrix in order */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = ( m * n )-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if (matrix[mid/n][mid % n] == target){
                return true;
            }
            else if (matrix[mid/n][mid % n] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return false;
    
    }
        
}