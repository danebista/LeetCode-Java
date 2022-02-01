class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hashmap = new HashMap();
        for (int i=0; i<nums.length; i++){
            hashmap.put(nums[i], true);
        }
        for (int i=0; i<nums.length; i++){
            if (hashmap.containsKey(nums[i]-1)){
                hashmap.put(nums[i], false);
            }
        }
        int maximum_length=0;
        for (int val:nums){
            if (hashmap.get(val)){
                int tl=1;
                while(hashmap.containsKey(val+tl)) tl++;
                if (tl> maximum_length) maximum_length=tl;
            }
            

        }
        
        return maximum_length;
    }
}
