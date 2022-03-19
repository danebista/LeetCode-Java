/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int candidate = 0;
        for (int i=1; i< n; i++){
            if (knows(candidate, i)){
                candidate = i;
            }
        }
        for (int i=0; i<n; i++){
            if (i!=candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }
}
