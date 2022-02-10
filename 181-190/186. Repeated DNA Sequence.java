class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        HashMap <String, Integer> hashmap = new HashMap(); 
        
        if (s.length()<10) return res;
    
        String first = s.substring(0,10);
        hashmap.put(first, 1);
        sb.append(first);
        for (int i=10; i< s.length(); i++){
            sb.append(s.charAt(i));
            
            sb.deleteCharAt(0);
            String temp = sb.toString();
            hashmap.put(temp, hashmap.getOrDefault(temp,0)+1);
            if (hashmap.get(temp)==2) res.add(temp);
        }
        
        return res;
        
    }
}
