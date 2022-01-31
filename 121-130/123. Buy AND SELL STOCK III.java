class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minPro = Integer.MAX_VALUE;
        int maxPro=0;
        for(int i=0; i<prices.length;i++){
            minPro= Math.min(minPro, prices[i]);
            maxPro =  Math.max(maxPro, prices[i]-minPro);
            left[i] = maxPro;
        } 
        
        int rightMax =0;
        int pro = 0;
        for (int j=prices.length-1; j>=0; j--){
            rightMax=Math.max(rightMax, prices[j]);
            pro = Math.max(pro, rightMax-prices[j]);
            right[j] = pro;
        }
        
        int max_pro=right[0];
        for (int i=1; i<prices.length;i++){
            max_pro=Math.max(max_pro, left[i-1]+ right[i]);
        }
        
        return max_pro;
    }
}