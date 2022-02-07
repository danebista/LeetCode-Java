class Solution {
    boolean[][] isPalin;
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        helper(result, new ArrayList(), s, 0);
        return result;
    }
    
    public void helper(List<List<String>> result, List<String> current, 
                      String s, int i){
        if (i == s.length()){
            result.add(new ArrayList(current));
            return;
        }
        
        for (int j=i; j<s.length();j++){
            if(isPalindrome(s,i,j)){
                current.add(s.substring(i,j+1));
                helper(result, current, s, j+1);
                current.remove(current.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i<=j){
           if (s.charAt(i++) != s.charAt(j--)) return false;  
        }
        
        return true;
    }
    
     
}
