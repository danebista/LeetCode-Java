
public class Solution extends Reader4{
    public int read(char[] buf, int n){
        int read = 0;
        char[] buf4 = new char[4];

        while ( read < n){
            int charsAtATime = read4(buf4);
            
            for (int i = 0 ; i< charsAtATime && read<n; i++){
                buf[read] = buf4[i];
                read++; 
            }
            if (charsAtATime<4) break;
        }
        return read;
    }
}
