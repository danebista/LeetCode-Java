class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        for (int i=0;i<nums.length;i++){
            if (hashmap.containsKey(nums[i])){
               int iIndex = hashmap.get(nums[i]);
               if (Math.abs(iIndex-i)<=k) return true;
            }
            hashmap.put(nums[i],i);
        }
        
        return false;
    }
}
