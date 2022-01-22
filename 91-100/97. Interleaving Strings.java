class Solution {
    HashMap<String, Boolean> hashmap;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        
        hashmap = new HashMap();
        if (m+n!=o) return false;
        
        return helper(s1,s2,s3,m,n,o,0,0,0);
    }
    
    public boolean helper(String s1, String s2, String s3, int l1, int l2, int l3, int p1, int p2, int p3){
     
       
        if (l3==p3){
            if (l1==p1 && l2==p2){
                return true;
            }
            return false;
        }
        
         String key = Integer.toString(p1)+ "*" + Integer.toString(p2) + "*" + Integer.toString(p3);
       
        
        if (hashmap.containsKey(key)){
            return hashmap.get(key);
        }
        
        if (p1==l1){
            
            boolean value = s2.charAt(p2)==s3.charAt(p3)? helper(s1, s2, s3, l1, l2, l3, p1, p2+1,p3+1): false;
                        hashmap.put(key, value);
            return value;
        }
            
        if (p2==l2){
            boolean value = s1.charAt(p1)==s3.charAt(p3)? helper(s1, s2, s3, l1, l2, l3, p1+1, p2,p3+1): false;
            hashmap.put(key, value);
            return value;
        }
        
        boolean one=false, two= false;
        
        if(s1.charAt(p1) == s3.charAt(p3)){
            one = helper(s1,s2,s3,l1,l2,l3,p1+1,p2,p3+1);
        }
        if (s2.charAt(p2) == s3.charAt(p3)){
            two = helper(s1,s2,s3,l1,l2,l3,p1,p2+1,p3+1);
        }
        
        boolean finalResult = one || two;
        hashmap.put(key, finalResult);
        
        return finalResult;
    }
}
