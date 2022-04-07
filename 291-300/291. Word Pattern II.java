public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    HashMap<Character, String> hashmap = new HashMap();
    Set<String> used = new HashSet();
    
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here

        return helper(pattern, str);
    }

    public boolean helper(String pattern,String str){   
        if (pattern.length()==0){
            return str.length()==0;
        }
        char pattern1 = pattern.charAt(0);
        if (hashmap.containsKey(pattern1)){
            if (!str.startsWith(hashmap.get(pattern1))) return false;
            return helper(pattern.substring(1), str.substring(hashmap.get(pattern1).length()));
        }

        for (int i=0; i< str.length(); i++){
            String str1 = str.substring(0, i+1);
            if (used.contains(str1)) continue;
            hashmap.put(pattern1, str1);
            used.add(str1);
            if (helper(pattern.substring(1), str.substring(i+1))){
                return true;
            }
            hashmap.remove(pattern1);
            used.remove(str1);
        }
        
        return false;
        
        
    }
}
