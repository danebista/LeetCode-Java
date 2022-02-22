public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        int index1= -1, index2=-1;
        int shortestDistance = Integer.MAX_VALUE;

        for (int i=0; i<words.length; i++){
            if (words[i].equals(word1)){
                index1=i;
            }
            if (words[i].equals(word2)){
                index2=i;
            }
            if (index1!=-1 && index2!=-1){
                shortestDistance = Math.min(shortestDistance, Math.abs(index1-index2));   
            }
        }

        return shortestDistance;
    }
}
