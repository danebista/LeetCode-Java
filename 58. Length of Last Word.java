class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        
        while(s.charAt(index)== ' ') index--;
        
        int count = 0;
        for (int i=index; i>=0; i--){
            if (s.charAt(i)== ' '){
                break;
            }
            count++;
        }
        
        return count;
    }
}
