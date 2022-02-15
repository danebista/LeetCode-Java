public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        for (int i=0; i< nums.length; i++){
            if (nums[i]> lower){
                if (nums[i]-lower==1){
                    result.add(lower+"");
                }
                else{
                    result.add(lower+"->"+(nums[i]-1));
                }
            }
            if (nums[i]==Integer.MAX_VALUE) return result;
            lower = nums[i]+1;
        }
            if (lower<upper){
                result.add(lower+"->"+upper);
            }
            else if(lower==upper){
                result.add(lower+"");
            }
            
        return result;
        // write your code 
    }
}
