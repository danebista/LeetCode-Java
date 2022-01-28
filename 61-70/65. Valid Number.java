class Solution {
    public boolean isNumber(String s) {
        boolean eseen = false, dotseen = false, digitseen=false;
        int signCount = 0;
        
        for (int i=0; i<s.length(); i++){
            char chara = s.charAt(i);
            if (Character.isDigit(chara)){
                digitseen = true;
            }
            else if (chara == '+' || chara == '-'){
                if (signCount>1) return false;
             
               
                if (i>0 && (s.charAt(i-1) != 'e'))
                    return false;
                
               
                if (i==s.length()-1) return false;
                
              
                signCount+=1;
            }
            else if (chara == '.'){
                if (eseen || dotseen) return false;
                if (i==s.length()-1 && ! digitseen) return false;
                dotseen = true;
            }
            
            else if (chara =='e' || chara == 'E'){
                if (eseen|| i==s.length()-1 || !digitseen) return false;
                eseen = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
