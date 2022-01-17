class Solution {
    public int[][] generateMatrix(int n) {
        int l=0, top=0;
        int r=n-1, bottom=n-1;
        int[][] array = new int[n][n];
        int count =1;
        
        while(l<=r && top<=bottom){
            
            for (int i=l; i<=r; i++){
                array[top][i] = count;
                count+=1;
            }
            top+=1;
            
            for (int i=top; i<=bottom;i++){
                array[i][r] = count;
                count+=1;
            }
            
            r-=1;
            
            if (!(l<=r && top<=bottom)) break;
            for (int i=r; i>=l; i--){
                array[bottom][i] = count;
                count+=1;
            }
            
            bottom-=1;
            
            for (int i=bottom; i>=top; i--){
                array[i][l] = count;
                count+=1;
            }    
            l+=1;
        }
        
        return array;
    }
}
