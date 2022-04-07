public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> possibleAnswers = new ArrayList();
        int i=0;
        while(i<s.length()){
            int nextMove = i==0? s.indexOf("++"): s.indexOf("++",i);
            if (nextMove == -1) return possibleAnswers;
            String newMove = s.substring(0, nextMove)+"--"+s.substring(nextMove+2);
            possibleAnswers.add(newMove);
            i=nextMove+1;
        }

        return possibleAnswers;
    }
}
