class Solution {
    public String minWindow(String s, String t) {
        int i=0, j=0, count=0;
        boolean found = false;
        int l = 0, r = s.length()-1;
        HashMap<Character, Integer> hashMap = new HashMap();
        int min = s.length();
        for (int k=0; k< t.length();k++){
            hashMap.put(t.charAt(k), hashMap.getOrDefault(t.charAt(k),0)+1);
        }
        count = hashMap.size();
        
        while (j< s.length()){
            char atJ = s.charAt(j);
            j++;
            if (hashMap.containsKey(atJ)){
                hashMap.put(atJ, hashMap.get(atJ) -1);
                
                if (hashMap.get(atJ)==0) count-=1;
            }
            
            if (count>0) continue;
            
            while (count ==0){
                char atI = s.charAt(i);
                i++;
                if (hashMap.containsKey(atI)){
                    hashMap.put(atI, hashMap.get(atI)+1);
                    
                    if (hashMap.get(atI)>0) count+=1;
                }  
            }
            
            if (j-i<min){
                l=i-1;
                r=j;
                min = j-i;
                found = true;
            }
        }
        
        return found? s.substring(l,r):"";
    }
}