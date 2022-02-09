class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int method2=0;
        int count = 0;
        for (int i=columnTitle.length()-1; i>=0; i--){
            int offset = (int)(columnTitle.charAt(i) - 'A' + 1);
            res += offset * Math.pow(26, count);
            count+=1;
        }
        
        for (char c:columTitle){
            int offset = (int)(c-'A'+1);
            method2 = method2 *26+offset;
        }
        
        return method2;
        return res;
        
        
    }
}
