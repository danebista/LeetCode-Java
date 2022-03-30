public class ZigzagIterator {
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector */

    List<Integer> v1 = new ArrayList();
    List<Integer> v2 = new ArrayList();
    boolean isSwitched;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        this.v1 = v1;
        this.v2 = v2;
        isSwitched = true;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (!hasNext()) return -1;

        if (isSwitched){
            isSwitched = !isSwitched;
            if (v1.size()!=0) return v1.remove(0);
            return v2.remove(0);
        }
        else{
            isSwitched = !isSwitched;
            if (v2.size()!=0) return v2.remove(0);
            return v1.remove(0);
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return (v1.size()!=0 || v2.size()!=0);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
 