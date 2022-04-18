import java.util.function.Function;
public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    private char[][] image;
    public int minArea(char[][] image, int x, int y) {
        if (image==null || image.length==0 || image[0].length==0) return 0;

        this.image = image; 
        final int x1 = findLowerLimit(0, x, getRowWiseAllZeroRow);
        final int x2 = findUpperLimit(x+1, image.length, getRowWiseAllZeroRow); 
        final int y1 = findLowerLimit(0,y, getColumnWiseAllColumnZero);
        final int y2 = findUpperLimit(y+1, image[0].length, getColumnWiseAllColumnZero);
        return (x2-x1) * (y2-y1);    
    }

    public int findLowerLimit(int l, int r, Function<Integer, Boolean> validatorFunction){
        while(l<r){
            int m = l+(r-l)/2;
            if (validatorFunction.apply(m)) l=m+1;
            else r=m;
        }
        return l;
    }

    public int findUpperLimit(int l, int r, Function<Integer, Boolean> validatorFunction){
         while(l<r){
            int m = l+(r-l)/2;
            if (validatorFunction.apply(m)) r=m;
            else l=m+1;
        }
        return l;
    }

    Function<Integer, Boolean> getRowWiseAllZeroRow = new Function<Integer, Boolean>(){
        public Boolean apply(Integer rowIndex){
            return new String(image[rowIndex]).chars().allMatch(pixel->pixel=='0');
        }
    };

    Function<Integer, Boolean> getColumnWiseAllColumnZero = new Function<Integer, Boolean>(){
        public Boolean apply(Integer colIndex){
           for (int i=0; i<image.length; i++){
               if (image[i][colIndex]=='1') return false;
           }
           return true;
        }
    };
     
}

