class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();
        if (s.length()==0 || s==null || words==null|| words.length==0) return result;
        
        Map <String , Integer> wordFrequency = new HashMap();
        
        for (String word: words){
            wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+1);
        }
        
        int wordLength = words[0].length();
        int noOfWords = words.length;
        
        for (int i=0; i<=s.length()-wordLength*noOfWords; i++){
            Map <String , Integer> seenWords = new HashMap();
            for (int j=0; j<noOfWords;j++){
                int index = i+j*wordLength;
                String word = s.substring(index, index+wordLength);
                
                if (!wordFrequency.containsKey(word)) break;
                
                seenWords.put(word, seenWords.getOrDefault(word,0)+1);
                
                if (seenWords.get(word) > wordFrequency.get(word)) break;
                
                if (j+1 == noOfWords) result.add(i);
            }
        }
        
        return result;
        
    }
}
