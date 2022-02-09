class Solution {
    public int findPeakElement(int[] nums) {
        int l =0;
        int r = nums.length - 1;
        
        while (l<r){
            int mid = l+(r-l)/2;
            
            if (nums[mid] < nums[mid+1]){
                l = mid+1;
            }
            
            else{
                r=mid;
            }
        }
        
        return l;
    }
}
// Imagine cliimbig or falling from slope;