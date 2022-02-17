class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int nums1=-1;
        int nums2=-1;
        
        for(int num:nums){
            if (num==nums1){
                count1++;
            }
            else if(num==nums2){
                count2++;
            }
            else if (count1==0){
                nums1=num;
                count1=1;
            }
            else if (count2==0){
                nums2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        int n1=0;
        int n2=0;
        
        for (int num:nums){
            if (num==nums1) n1++;
            else if (num==nums2) n2++;
        }
        
        List<Integer>result=new ArrayList();
        if (n1> nums.length/3) result.add(nums1);
        if (n2> nums.length/3) result.add(nums2);
        
        return result;
    }
}
