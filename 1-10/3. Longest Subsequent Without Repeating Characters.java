class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_poi = 0;
        int b_poi = 0;
        Set <Character> sets = new HashSet<Character>();
        int max = 0;
        while(b_poi<s.length()){
            if (!sets.contains(s.charAt(b_poi))){
                sets.add(s.charAt(b_poi));
                b_poi++;
                max = Math.max(sets.size(), max);
            }
            else{
                sets.remove(s.charAt(a_poi));
                a_poi++;
            }
        }
        return max;
        
    }
}
