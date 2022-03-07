class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int next_2=0;
        int next_3=0;
        int next_5=0;
        int count=1;
        while(count<n){
            int next2= ugly[next_2]*2;
            int next3= ugly[next_3]*3;
            int next5 = ugly[next_5]*5;
            
            int min_no = Math.min(next2, Math.min(next3, next5));
            
            if (min_no == next2) next_2++;
            if (min_no == next3) next_3++;
            if (min_no==next5) next_5++;
            ugly[count++] = min_no;
        }
        return ugly[n-1];
    }
}
