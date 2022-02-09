class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        
        while (n>=5){
            res+= (int)Math.floor(n/5);
            n=(int) Math.floor(n/5);
        }
        
        return res;
    }

}
