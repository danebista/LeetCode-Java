class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            char c= (char)('A'+ (columnNumber-1)%26);
            ans.insert(0, c);
            columnNumber=(columnNumber-1)/26;
        }
        
        return ans.toString();
    }
}
