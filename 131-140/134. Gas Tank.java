class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost=0;
        int surplus = 0;
        int index=0;
        
        for (int i=0; i<gas.length;i++){
            totalCost+=gas[i]-cost[i];
            surplus+=gas[i]-cost[i];
            if (surplus< 0){
                surplus=0;
                index=i+1;
            }
        }
        
        return totalCost >= 0? index : -1;
    }
}
