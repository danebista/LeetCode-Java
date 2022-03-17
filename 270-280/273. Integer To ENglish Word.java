class Solution {
    final String[] THOU = {"","Thousand", "Million", "Billion"};
    private final String[] HUNDR = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                                                  "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
                                                  "Seventeen","Eighteen","Nineteen"};
    public String numberToWords(int num) {
        if (num ==0) return "Zero";
        
         StringBuilder sb = new StringBuilder();
         int index = 0;
         while (num>0){
             if (num %1000 !=0){
                 StringBuilder temp = new StringBuilder();
                 helper(temp, num%1000);
                 sb.insert(0, temp.append(THOU[index]).append(" "));
             }
             index++;
             num/=1000;
         }
         
         return sb.toString().trim();
     }
    
    public void helper(StringBuilder sb, int num){
        if (num==0){
            return;
        }
        else if (num <20){
            sb.append(LESS_THAN_TWENTY[num]).append(" ");
            return;
        }
        else if (num<100){
            sb.append(HUNDR[num/10]).append(" ");
            helper(sb, num%10);
        }
        else {
            sb.append(LESS_THAN_TWENTY[num/100]).append(" Hundred ");
            helper(sb, num%100);
        }
    }
    
}
