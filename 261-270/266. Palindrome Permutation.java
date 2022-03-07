public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        int[] count = new int[128];
        for (char c: s.toCharArray()){
            count[c] = count[c]+1;
        }

        int scount = 0;
        for (int i=0; i<128; i++){
            scount+= count[i] %2;
        }

        return scount <=1;
    }
}
