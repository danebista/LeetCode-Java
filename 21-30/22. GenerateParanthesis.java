class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> output_arr = new ArrayList();
        
       paranthesisGenerator(output_arr, 0, 0, "",n);
       return output_arr; 
    }
    
    public void paranthesisGenerator(List<String> output_arr, int open, int close, String answer_string, int n){
        if (answer_string.length()== 2 *n){
            output_arr.add(answer_string);
            return;
        }
        
        if (open< n) paranthesisGenerator(output_arr, open+1, close, answer_string +"(", n);
        if (close<open) paranthesisGenerator(output_arr, open, close+1, answer_string+ ")", n);
    }
}
