class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        
        helper(result, new StringBuilder(), s, 4);
        return result;
    }
    
    public void helper(List<String> result, StringBuilder res, String s, int sections){
       
        
        if (s.length()==0 && sections==0){
        
            result.add(res.substring(0, res.length()-1).toString());
            return;
        }
        
        if (s.length()>0 && sections==0) return;
        if (sections>0 && s.length()==0) return;
        int min = Math.min(3, s.length());
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i< min; i++){
            sb.append(s.charAt(i));
            
            int value = Integer.parseInt(sb.toString());
            if (sb.length()==2 && value <10) continue;
            if (sb.length()==3 && (value>255 || value <100)) continue;
            StringBuilder temp =  new StringBuilder(res);
            res.append(sb.toString()).append('.');
            helper(result, res, s.substring(i+1, s.length()), sections-1);
            res = temp;
        }
    }
}
