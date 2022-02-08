class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        
        boolean sign = (numerator< 0) == (denominator<0);
        if (numerator == 0){
            sign = true;
        }
        
        long num = numerator;
        long den = denominator;
        if (num<0){
            num=-1 * num;
        }
        if (den<0){
            den = -1 * den;
        }
      
        
        long q = num/den;
        long r = num % den;
        ans.append(q);
        
        if (r==0) return sign?ans.toString():"-"+ans.toString();
        
        ans.append('.');
        HashMap<Long, Integer> hashmap = new HashMap();
        while(r != 0){
            if (hashmap.containsKey(r)){
                int index = hashmap.get(r);
                ans.insert(index, '(');
                ans.append(')');
                break;
            }
            hashmap.put(r, ans.length());
            r=r*10;
            q=r/den;
            r=r%den;
            ans.append(q);
        }
        
        
        return sign?ans.toString():"-"+ans.toString();
    }
}
