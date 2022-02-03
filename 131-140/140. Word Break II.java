class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList();
    
        helper(result, new ArrayList(), hashSet, s, 0);
        
        return result;
    }
    
    public void helper(List<String> result, List<String> current, HashSet<String> hashSet, String s, int index){
        
        if (index==s.length()){
            result.add(String.join(" ", current));
            return;
        }
        
        for (int i=index+1;i<=s.length(); i++){
            String prefix = s.substring(index,i);
            if (hashSet.contains(prefix)){
                current.add(prefix);
                helper(result, current, hashSet, s, i);
                current.remove(current.size()-1);
            }
        }
        
    }
}
