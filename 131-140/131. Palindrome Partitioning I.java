class Solution {
    boolean[][] isPalin;
    
    public List<List<String>> partition(String s) {
        isPalin = new boolean [s.length()][s.length()];
        List<List<String>> result = new ArrayList();
        helper(result, new ArrayList(), 0, s);
        return result;
    }
    
    public void helper(List<List<String>> result, List<String> current, int i, String s){
        if (i==s.length()){
            result.add(new ArrayList(current));
            return;
        }
        
        for (int j=i; j<s.length(); j++){
            if (isPalindrome(s,i,j)){
                current.add(s.substring(i, j+1));
                helper(result, current, j+1, s);
                current.remove(current.size()-1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int i, int j){
        if (isPalin[i][j]) return true;
        while(i<=j){
            if (s.charAt(i++)!=s.charAt(j--)) return false;
        }
        
        return isPalin[i][j];
    }
}
