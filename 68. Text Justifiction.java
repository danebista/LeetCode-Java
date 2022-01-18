class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        int i=0;
        int n=words.length;
        while(i<n){
            int j = i+1;
            int wordLength=words[i].length();
            
            while (j<n && (wordLength + words[j].length() + j-i<=maxWidth)){
                wordLength+=words[j].length();
                j++;
            }
            
            int numOfWords = j-i;
            int difference = maxWidth - wordLength;
            if (numOfWords == 1 || j>=n){
                result.add(leftJustify(words,difference, i, j));
            }else{
                result.add(middleJustify(words, difference, i, j));
            }
            
            i=j;
        }
        return result;
    }
                           
    private String leftJustify(String[] words, int difference, int i , int j){
        StringBuilder res = new StringBuilder(words[i]);
        int spacesAtRight = difference-(j-i-1);
        
        for (int k=i+1; k<j;k++){
            res.append(" ").append(words[k]);
        }
        
        res.append(" ".repeat(spacesAtRight));
        
        return res.toString();
    }
                           
    private String middleJustify(String[] words, int difference, int i, int j){
        StringBuilder res = new StringBuilder(words[i]);
        int spaces = difference/(j-i-1);
        int extraSpaces = difference %(j-i-1);
        
        for (int k=i+1; k<j;k++){
            int spacesToAppend = spaces + (extraSpaces>0?1:0);
            extraSpaces-=1;
            res.append(" ".repeat(spacesToAppend)).append(words[k]);
        }
        
        return res.toString();
    }
}
