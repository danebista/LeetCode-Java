class Solution {
    public int countPrimes(int n) {
        boolean notprime[] = new boolean[n];
        for(int i=2;i*i<n;i++){
            if(notprime[i]) continue;
            for(int j=i;j*i<n;j++){
                notprime[i*j]=true;
            }
        }
        
        int primeCount=0;
        for (int i=2; i<n;i++){
            if (notprime[i]) continue;
            primeCount++;
        }
        return primeCount;
    }
}
