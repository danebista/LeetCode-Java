class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        char operator='+';
        char[]arr =s.toCharArray();
        
        for (int i=0; i< s.length();i++){
            if (arr[i]==' '){
                continue;
            }
            
            if (Character.isDigit(arr[i])){
                StringBuilder num =new StringBuilder();
                while (i< arr.length && Character.isDigit(arr[i])){
                    num.append(arr[i++]);
                }
                i--;
                int currentNum= Integer.parseInt(num.toString());
                if (operator=='-'){
                    currentNum=-1*currentNum;
                }
                else if(operator == '*'){
                    int prev = stack.pop();
                    currentNum *= prev;
                }
                else if (operator == '/'){
                    int prev = stack.pop();
                    currentNum = prev/currentNum;
                }
                stack.push(currentNum);
            }
            else{
                operator=arr[i];
            }
        }
        int result=0;
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        
        
        return result;
    }
}
