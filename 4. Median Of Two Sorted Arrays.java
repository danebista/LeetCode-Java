class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l = 0;
        int h = len1;
        int t = len1 + len2;
        
        while (l <= h){
            int c1 = (l + h) / 2;
            int c2 = (t + 1) / 2 - c1;
            int l1 = c1 ==0 ? Integer.MIN_VALUE : nums1[c1-1];
            int l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[c2-1];
            int r1 = c1 == len1 ? Integer.MAX_VALUE : nums1[c1];
            int r2 = c2 == len2 ? Integer.MAX_VALUE : nums2[c2];
            
            if (l1 <= r2 && l2 <= r1){
                if (t % 2 == 0){
                    return (Math.max(l1,l2)+Math.min(r1,r2)) / 2.0;
                }
                else {
                    return Math.max( l1, l2);
                }
            }
            else if (l1>r2){
                h = c1 - 1;
            }
            else {
                l = c1 + 1;
            }
        }
        return 0.0;
    }

}
