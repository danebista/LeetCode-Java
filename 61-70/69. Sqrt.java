class Solution {
    public int mySqrt(int x) {
        if (x==0) return 0;
        int l=0;
        int r=x;
        int res = 0;
        while(l<=r){
            int mid = l + (r-l)/2 ;

            if (x <=mid/x){
                l= mid+1;
                res = mid;
            }
            else{
                r= mid-1;
            }
        }
    }
}
