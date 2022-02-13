class Solution {
    public int myAtoi(String s) {
        int index = 0;
        
        while(index < s.length() && s.charAt(index)==' '){
            index++;
        }
        
        if (index>= s.length()) return 0;
        int sign = 1;
        if (s.charAt(index)== '+' || s.charAt(index) == '-'){
            if (s.charAt(index)=='-'){
                sign =-1;
            }
            index++;
        }
        
        if (index >=s.length()) return 0;
        int value = 0;
        
        while (index<s.length() && (s.charAt(index)>='0' && s.charAt(index)<='9')){
            if(value>Integer.MAX_VALUE/10 ||
              (value==Integer.MAX_VALUE/10 && s.charAt(index)-'0' > Integer.MAX_VALUE%10)) {
                if (sign==-1){
                    return Integer.MIN_VALUE;
                }
                
                return Integer.MAX_VALUE;
            } 
            value = value *10 + s.charAt(index)-'0';
            index++;
    }
        return value * sign;
        
    }
}
