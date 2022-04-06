public class Solution {
    /**
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    public boolean canWin(String s) {
        // write your code here
        if (s==null || s.length()<2)return false;
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                String nextString = s.substring(0,i)+"--"+s.substring(i+2);
                if (!canWin(nextString)) return true;
            }
        }

        return false;
    }
}
