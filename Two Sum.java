class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if (hashMap.containsKey(complement = target-nums[i])){
                return new int[]{hashMap.get(complement = target-nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("no match found");
    }
}
