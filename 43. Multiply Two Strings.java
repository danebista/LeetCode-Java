class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] save = new int[num1.length() + num2.length()+1];
        int m = num1.length();
        int n = num2.length();
        num1 =  m>1?reverse(num1): num1;  
        num2 =  n>1?reverse(num2):num2;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int digit = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                save[i+j] += digit;
              a
                save[i+j+1] += (save[i+j]/10);
                save[i+j] = save[i+j] % 10;
            }
        }
        
        reverseArray(save, 0, save.length-1);
        int index = 0;
        
        while(index< save.length && save[index]==0) index++;
        StringBuilder res = new StringBuilder();
        while(index < save.length){
            res.append(save[index]);
            ++index;
        }
        
        return res.toString(); 
    }
    
    public void reverseArray(int[]save, int i, int j){
        while(i<j) swap(save, i++, j--);
    }
    
    public void swap(int[] save, int i, int j){
        int temp = save[i];
        save[i] = save[j];
        save[j] = temp;
    }
    public String reverse(String num){
         StringBuilder sb=new StringBuilder(num);
         sb.reverse(); 
         return sb.toString();
    }
}
