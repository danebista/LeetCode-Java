public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here

        HashMap<Character, Character> hashmap = new HashMap();
        hashmap.put('0','0');
        hashmap.put('1','1');
        hashmap.put('6','9');
        hashmap.put('8','8');
        hashmap.put('9','6');
        int l = 0;
        int r = num.length()-1;

        while (l<=r){
            if (!hashmap.containsKey(num.charAt(r)) 
            || num.charAt(l) != hashmap.get(num.charAt(r))) return false;
            l++;
            r--;
        }
        
        return true;
    }
}
