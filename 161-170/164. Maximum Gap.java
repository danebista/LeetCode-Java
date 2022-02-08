class Solution {
    public int maximumGap(int[] nums) {
        int min= nums[0];
        int max = 0;
        int n = nums.length;
        
        for (int num:nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        
        int interval = (int)Math.ceil(((max-min)+0.0)/(n-1));
        int[] bucketsMin = new int[n-1];
        int[] bucketsMax = new int[n-1];
        System.out.println(interval);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, -1);
        
        for (int i=0; i< nums.length; i++){
            if (nums[i]==min || nums[i]==max) continue;
            int index = (nums[i]-min)/interval;
            bucketsMin[index] = Math.min(bucketsMin[index], nums[i]);
            bucketsMax[index] = Math.max(bucketsMax[index], nums[i]);
        }
        
        int prev = min;
        int gap = 0;
        for (int i=0; i< bucketsMin.length; i++){
            if (bucketsMax[i]==-1) continue;
            gap = Math.max(gap, bucketsMin[i]-prev);
            prev=bucketsMax[i];
        }
        
        gap = Math.max(gap, max-prev);
        
        return gap;
    }
}
