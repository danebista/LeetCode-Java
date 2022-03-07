class Solution {
    public boolean isUgly(int n) {
       if (n==0) return false;
       for (int j: Arrays.asList(2,3,5)){
           while (n%j==0){
               n=n/j;
           }
       }
       return n==1;
    }
}
