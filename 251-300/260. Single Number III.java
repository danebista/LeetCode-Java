class Solution {
    public int[] singleNumber(int[] nums) {
        int xy=0;
        for(int num:nums) xy^=num;
        xy &=-xy;
        int[] res = new int[2];
        for (int num:nums){
            if ((xy & num) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
