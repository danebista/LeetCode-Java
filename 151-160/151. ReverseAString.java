class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        
        StringBuilder res = new StringBuilder();
        
        String a[] = s.split("\\s+");
        
        for (int k=a.length-1; k>=1; k--){
            res.append(a[k]).append(" ");
        }
        res.append(a[0]);
        return res.toString();
    }
}
