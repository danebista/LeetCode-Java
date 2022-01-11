class Solution {
    Boolean [][] cache;
    
    public boolean isMatch(String s, String p) {
        this.cache= new Boolean[s.length()+1][p.length()+1];
        return regularExpressionMatcher(0,0,s,p);
    }
    
    public boolean regularExpressionMatcher(int i, int j, String s, String p){
        if (cache[i][j] != null) return cache[i][j];
        
        if (i>=s.length() && j>=p.length()) return cache[i][j]=true;
        if (j>=p.length()) return cache[i][j]=false;
        
        boolean match = i< s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        boolean result = false;
        if (j+1< p.length() && p.charAt(j+1)=='*'){
            result = regularExpressionMatcher(i,j+2, s,p) ||
                (match && regularExpressionMatcher(i+1,j,s,p));
        }
        else if(match){
            result = regularExpressionMatcher(i+1,j+1,s,p);
        }
        
        return cache[i][j]=result;
    }
}
