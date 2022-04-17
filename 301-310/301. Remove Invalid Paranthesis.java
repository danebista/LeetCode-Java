class Solution {
    HashSet<String> visited;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        visited = new HashSet();
        result = new ArrayList();
        int numberOfExtraBrackets = getMinBracs(s);
        
        getSolution(s, numberOfExtraBrackets);
        
        return result;
        
    }
    
    public void getSolution(String s, int mra){
        if (visited.contains(s)) return;
        visited.add(s);
        if (mra == 0){
            if (getMinBracs(s)==0){
                result.add(s);
            }
        }
        
        for (int i=0; i<s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            
            getSolution(left+right, mra-1);
        }
    }
    
    public int getMinBracs(String s){
        Stack<Character> stack = new Stack();
        for (int i=0; i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i)==')'){
                if (stack.isEmpty()){
                    stack.push(s.charAt(i));
                }
                else if (stack.peek()==')'){
                    stack.push(s.charAt(i));
                }
                else if (stack.peek()=='('){
                    stack.pop();
                }
            }
        }
        
        return stack.size();
    }
}
