class Solution {
    public boolean isPalindrome(int x) {
        if ((x!=0 && x % 10 ==0) || x<0) return false;
        int a = x;
        int r=0;
     
        while(x!=0){
            r=r*10+x%10;
            x=x/10;
        }
    
        if (r== a) return true;
        
        return false;
    }
}
    