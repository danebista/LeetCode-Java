public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> xrows = new ArrayList();
        List<Integer> yrows = new ArrayList();

        for (int i=0; i< grid.length; i++){
            for (int j=0; j< grid[0].length; j++){
                if (grid[i][j]==1){
                    xrows.add(i);
                }
            }
        }

        for (int j=0; j< grid[0].length; j++){
            for (int i=0; i< grid.length; i++){
                if (grid[i][j]==1){
                    yrows.add(j);
                }
            }
        }

        int x_mid = xrows.get(xrows.size()/2);
        int y_mid = yrows.get(yrows.size()/2);
        int dist = 0;
        
        for (int x: xrows){
            dist+=Math.abs(x-x_mid);
        }
        for(int y: yrows){
            dist+=Math.abs(y-y_mid);
        }

        return dist;
    }
}
