class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long power = n;
        
        if (power<0) power = -1 * power;
        
        while(power>0){
            if (power % 2 == 1){
                ans *= x;
                power--;
            }
            else{
                x=x*x;
                power/=2;
            }
        }
        
        ans = n>0?ans: 1.0/ans;
        
        return ans;
    }
}
