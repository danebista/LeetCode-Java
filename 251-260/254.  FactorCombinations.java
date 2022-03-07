public class Solution {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here

        List<List<Integer>> result = new ArrayList();
        helper(result, new ArrayList(), 2, n);
        result.remove(result.size()-1);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> current, int index, int n){
        if (n==1){
            result.add(new ArrayList(current));
        }

        if (n<1){
            return;
        }

        for (int i=index; i<=n; i++){
            if (n%i == 0){
                current.add(i);
                helper(result, current, i, n/i);
                current.remove(new Integer(i));
            }
        }
    }
}
