class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1) return intervals;
        List<int[]> output = new ArrayList();
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0], arr2[0]));
        int[] current = intervals[0];
        output.add(current);
        
        System.out.println(current[1]);
        
        for (int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            int curr_start = current[0];
            int curr_end = current[1];
            
            if (curr_end>= start){
                current[1] = Math.max(curr_end, end);
            }
            else{
                current = interval;
                output.add(current);
            }
        }
        
        return output.toArray(new int[output.size()][]);
        
        
    }
}
 