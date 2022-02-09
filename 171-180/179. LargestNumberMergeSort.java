class Solution {
    public String largestNumber(int[] nums) {
        int count = 0;
        for (int num:nums){
            if (num==0) count++;
        }
        if (count==nums.length) return String.valueOf(0);
        
        int[] numbers = mergeSort(0, nums.length-1, nums);
       
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++){
            sb.append(numbers[i]);
        }
        
        return sb.toString();
    }
    
    public int[] mergeSort(int left, int right,int[] nums){
        if (left==right){
            int[] temp = new int[1];
            temp[0] = nums[left];
            return temp;
        }
        
        int mid = left +(right-left)/2;
        int[] lefty = mergeSort(left, mid, nums);
        int[] righty = mergeSort(mid+1, right, nums);
        return merge(lefty, righty);
    }
    
    public int[] merge(int[]left, int[]right){
        int[] temp = new int[left.length+right.length];
        int tempIndex = 0;
        int l=0; int r=0;
        while(l<left.length && r<right.length){
            String s1 = String.valueOf(left[l])+ String.valueOf(right[r]);
            String s2 = String.valueOf(right[r]+ String.valueOf(left[l]));
            if (s1.compareTo(s2)>0){
                temp[tempIndex] = left[l];
                l++;
            }
            else{
                temp[tempIndex] = right[r];
                r++;
            }
            tempIndex++;
        }
        while(l<left.length){
            temp[tempIndex] = left[l];
            l++;
            tempIndex++;
        }
        
        while(r<right.length){
            temp[tempIndex] = right[r];
            r++;
            tempIndex++;
        }
        
        return temp;
    }
    
}
