class Solution {
    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
      
        return convertStringToAtoi(charArray);
        
    }
    
    public int convertStringToAtoi(char[] str){
        int i = 0;
        while(i< str.length && str[i] ==' '){
            i++;
            
        }
        int sign=1;
        if( i< str.length && str[i]=='+'){
            i++;
        }
        else if (i< str.length && str[i] == '-'){
            sign = -1;
            i++;
        }
        
        if (i>= str.length) return 0;
        int num=0;
        while(i<str.length && (str[i]>='0' && str[i]<='9')){
             if (num > Integer.MAX_VALUE / 10 || (num==Integer.MAX_VALUE/10 && str[i]-'0'                                    >Integer.MAX_VALUE % 10)) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            num = num*10+ Character.getNumericValue(str[i]);
            i++;
        } 
            
        
        return num*sign;
    }
}
