class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] wordList = s.split(" ");
        if (pattern.length() != wordList.length) return false;
        
        HashMap<Character, String> hashmap = new HashMap();
        HashMap<String, Boolean> used = new HashMap();
        for (int i=0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (!hashmap.containsKey(c)){
                if (used.containsKey(wordList[i])) return false;
                hashmap.put(c, wordList[i]);
                used.put(wordList[i], true);
            }
            
            if (!hashmap.get(c).equals(wordList[i])) return false;
        }
        
        return true;
    }
}
