class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        long Area1= (long)((ax2-ax1)*(ay2-ay1));
        long Area2= (long)((bx2-bx1)*(by2-by1));
        long overlap_x = (long)Math.max((long)(Math.min(ax2,bx2)-Math.max(bx1,ax1)),0);
    
        long overlap_y = (long)Math.max((long)(Math.min(ay2,by2)-Math.max(by1,ay1)),0);
        long overlap_area= (long)(overlap_x * overlap_y);
    
        return (int)(Area1+Area2-overlap_area);
    
    }
}
