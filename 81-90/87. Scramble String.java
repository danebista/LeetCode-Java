class Solution {
    HashMap<String, Boolean> hashmap = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            hashmap.put(s1+"*"+s2, true);
            return true;
        } 
        int n= s1.length();
        if (n<=1){
            hashmap.put(s1+"*"+s2, false);
            return false;
          
        } 
        
        if (hashmap.containsKey(s1+"*"+s2)) return hashmap.get(s1+"*"+s2);
        
        HashMap<Character, Integer> amap = new HashMap<>();
        HashMap<Character, Integer> bmap = new HashMap<>();
        
        for (int i=0; i<n; i++){
            amap.put(s1.charAt(i), amap.getOrDefault(s1.charAt(i),0)+1);
            bmap.put(s2.charAt(i), bmap.getOrDefault(s2.charAt(i),0)+1);
        }
        
        if (!amap.equals(bmap)){
            hashmap.put(s1+"*"+s2, false);
            return false;
        }
            
        for (int i=1; i<=n-1; i++){
            if ((isScramble(s1.substring(0,i), s2.substring(n-i,n))
               && isScramble(s1.substring(i, n), s2.substring(0,n-i)))
               || (isScramble(s1.substring(0,i), s2.substring(0,i)) &&
                  isScramble(s1.substring(i,n), s2.substring(i,n)))){
                hashmap.put(s1+"*"+s2, true);
                return true;
            }
        }
        
        hashmap.put(s1+"*"+s2, false);
        return false;
        
    }
}
