class Solution {
    public String shortestPalindrome(String s) {
        if (s.length()==0) return s;
        String reverse = new StringBuilder(s).reverse().toString();
        String l = s +"#"+ reverse;
        
        int[] p = new int[l.length()];
        
        for (int i=1; i<l.length();i++){
            // ends index for prefix
            int j = p[i-1];
            // move prefix to last equal poin
            while (j>0 && l.charAt(i) != l.charAt(j)){
                j=p[j-1];
            }
            // check from last equal point
            if (l.charAt(i)==l.charAt(j)){
                p[i] = j+1;
            }
        }
        
        return reverse.substring(0, s.length()-p[l.length()-1])+s;
    }
}
