public class Solution {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        int a_poi = 0;
        int b_poi = 0;
        if (s.length()<2) return s.length();

        HashMap<Character, Integer> hashMap = new HashMap();

        int n = s.length();
        int max_len = 0;

        while (b_poi < n){
            hashMap.put(s.charAt(b_poi), hashMap.getOrDefault(s.charAt(b_poi), 0)+1);
            while (hashMap.size()>2){
                hashMap.put(s.charAt(a_poi), hashMap.get(s.charAt(a_poi))-1);
        
                if (hashMap.get(s.charAt(a_poi)) == 0) {
                    hashMap.remove(s.charAt(a_poi)); 
                }
                a_poi++;
            }
            max_len = Math.max(max_len, b_poi-a_poi+1);
            b_poi++;
        }
        return max_len;
    }
}
