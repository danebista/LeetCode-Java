class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPro = Integer.MAX_VALUE;
        for (int i=0; i< prices.length;i++){
            minPro = Math.min(minPro, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPro);
        }
        
        return maxPro;
    }
}
