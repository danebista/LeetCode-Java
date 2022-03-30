public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here

        for (int i=0; i< rooms.length; i++){
            for (int j=0; j< rooms[0].length; j++){
                if (rooms[i][j]==0) {
                    int count =0;
                    helper(rooms, i, j, count);
                }
            }
        }
    }

    public void helper(int[][] rooms, int i, int j, int count){
        if (i < 0 ||  j< 0 || i>= rooms.length || j>= rooms[0].length ||
        rooms[i][j] < count) return;

        rooms[i][j] = count;

        helper(rooms, i-1, j, count + 1);
        helper(rooms, i+1, j, count + 1);
        helper(rooms, i, j+1, count + 1);
        helper(rooms, i, j-1, count+1);
    }
}