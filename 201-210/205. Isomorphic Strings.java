class Solution {
    public boolean isIsomorphic(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (m!=n) return false;
        
        HashMap<Character, Character> charMap = new HashMap();
        HashMap<Character, Boolean> seenMap = new HashMap();
        
        for (int i=0; i< m; i++){
            if (!charMap.containsKey(s.charAt(i))){
                if (seenMap.containsKey(t.charAt(i))) return false;
                charMap.put(s.charAt(i), t.charAt(i));
                seenMap.put(t.charAt(i), true);
            }
            else if (charMap.containsKey(s.charAt(i))){
                if (charMap.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        
        return true;
        
    }
}
