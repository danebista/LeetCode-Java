class Solution {
    int[][] cache;
    public int numDistinct(String s, String t) {
        cache = new int[s.length()][t.length()];
        for (int i=0; i<s.length();i++){
            for (int j=0; j<t.length(); j++){
                cache[i][j] = -1;
            }
        }
        return helper(s, t, 0,0);
    }
    
    public int helper(String s, String t, int i, int j){
        if (j==t.length()) return 1;
        if (i==s.length()) return 0;
        if (cache[i][j]!=-1) return cache[i][j];
        
        if (s.charAt(i) == t.charAt(j)){
            cache[i][j] = helper(s,t,i+1,j) + helper(s,t,i+1,j+1);
        }
        else {
            cache[i][j] = helper(s,t,i+1,j);
        }
        
        return cache[i][j];
    }
}
