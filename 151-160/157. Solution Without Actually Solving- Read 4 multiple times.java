/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

      public class Solution extends Reader4 {
        /**
         * @param buf destination buffer
         * @param n maximum number of characters to read
         * @return the number of characters read
         */
        public int tempCount = 0;
        public int tempPtr = 0;
        char[] buff4 = new char[4];
        public int read(char[] buf, int n) {
            // Write your code here
            int total  = 0;
            while (total<n){
                if (tempPtr==0){
                    tempCount = read4(temp);
                }
    
                if (tempCount == 0) break;
                
                while (total<n && tempPtr< tempCount){
                    buf[total] = buff4[tempPtr];
                    total++;
                    tempPtr++;
                }
                if (tempPtr == tempCount) tempPtr =0;
                if (tempCount<4) break;
            }
    
            return total;
        }
    }
    