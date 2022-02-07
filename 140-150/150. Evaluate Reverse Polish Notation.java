class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for (String token: tokens){
            if ("+-/*".contains(token)){
                int y = stack.pop();
                int x = stack.pop();
                if ("+".equals(token)){
                    stack.push(x+y);
                }
                else if ("-".equals(token)){
                    stack.push(x-y);
                }
                
                else if ("*".equals(token)){
                    stack.push(x*y);
                }
                else {
                    stack.push(x/y);
                }
            }
            
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
