class Solution {
    List<String> newList;
    public List<String> letterCombinations(String digits) {
        this.newList = new ArrayList<String>();
        if (digits==null || digits.length()==0)  return newList;
        
        String[] mappings = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        recursiveCombo("", 0, mappings, digits);
        return newList;
    }
    
    public void recursiveCombo(String current, int index, String[]mappings, String digits){
        if (index==digits.length()) {
            newList.add(current);
            return;
        }
        String letters = mappings[digits.charAt(index)-'0'];
        
        for (int i=0; i<letters.length(); i++){
            recursiveCombo(current+letters.charAt(i), index+1, mappings, digits);
        }
        
    }
}
