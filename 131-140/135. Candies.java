class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <=1) return ratings.length;
        int up = 0;
        int down = 0;
        int previousSlope = 0;
        int currentSlope = 0;
        int candies = 0;
        for (int i=1; i< ratings.length; i++){
            if (ratings[i]>ratings[i-1]){
                currentSlope = 1;
            }
            else if(ratings[i]< ratings[i-1]){
                currentSlope = -1;
            }
            else {
                currentSlope = 0;
            }
       // hello/- || /\ || \- 
            if ((previousSlope<0 && currentSlope>=0) || previousSlope>0 && currentSlope==0){
                candies+=sum(up) + sum(down)+ Math.max(up,down);
                up = 0;
                down = 0;
            }
            
            previousSlope = currentSlope;
            if (currentSlope>0) up++;
            else if (currentSlope<0) down++;
            else candies++;
            
        }
        
        candies += sum(up) +sum(down) +Math.max(up, down) +1;
        
        return candies;
    }
    
    private int sum(int n){
        return ((n*(n+1))/2);
    }
}
