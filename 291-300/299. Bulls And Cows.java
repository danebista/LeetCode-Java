class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int bulls = 0;
        int cows = 0;
        
        for (int i=0; i<secret.length();i++){
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            else{
                int s = secret.charAt(i)-'0';
                int g = guess.charAt(i)-'0';
                if (nums[s]++<0) cows++;
                if(nums[g]-->0) cows++;
            }
        }
        
        return String.valueOf(bulls)+"A"+String.valueOf(cows)+"B";
    }
}
