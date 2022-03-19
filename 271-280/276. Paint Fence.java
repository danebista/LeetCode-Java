public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        if (n == 1) return k;
        long first = k * 1;
        long second = k * (k-1);
        long total = first + second;

        for(int i=3; i<=n; i++){
            first = second;
            second = total * (k-1);
            total = first + second;
        }

        return (int)total;
    }
}
