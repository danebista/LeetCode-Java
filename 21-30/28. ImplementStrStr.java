class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        int m = haystack.length();
        int n = needle.length();
        
        if (m<n) return -1;
        
        for (int i= 0; i<=m-n; i++){
           if (haystack.substring(i, n+i).equals(needle)){
               return i;
           }
        }
        
        return -1;
    }
}
