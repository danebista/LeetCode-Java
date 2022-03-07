class Solution {
    public int countDigitOne(int n) {
        if (n==0) return 0;
        if (n<=9) return 1;
        
        HashMap<Integer, Integer> hashmap = new HashMap();
        hashmap.put(9,1);
        
        int i=9;
        int index = 0;
        int divisor = 10;
        
        while (divisor <= n/10){
            hashmap.put(10*i+9, 10* hashmap.get(i)+ divisor);
            divisor = divisor *10;
            i=10*i+9;
        }
        
        int ans=0;
        int firstDigit = n/divisor;
        int rem = n% divisor;
        ans += hashmap.get(divisor-1)* firstDigit;
        ans+=(firstDigit > 1)?divisor:0;
        ans+=(firstDigit==1)?rem+1:0;
        ans+=countDigitOne(rem);
        
        return ans;
        
    }
}

//16 = 1* f(9) + 6 + 1 + f(6);
//f(99) = 10 *f(9) +10;
//26 = 2* f(9)+ 10+f(6);

// f(19)= 11-19=10
//f(10)=1
//f(9)=1
//f(999) = 10* f(99)+ 100;