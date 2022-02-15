class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet();
        while (n!=1){
            int curr = n;
            int sum = 0;
            while(curr!=0){
                sum+= (curr % 10) * (curr % 10);
                curr = curr / 10;
            }
            
            if (hashSet.contains(sum)){
                return false;
            }
            hashSet.add(sum);
            n = sum;
        }
        
        return true;
    }
}
