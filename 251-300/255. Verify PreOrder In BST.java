public class Solution {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for  (int i=0; i<preorder.length; i++){
            while (!stack.isEmpty() && preorder[i] > stack.peek()){
                root = stack.pop();
            }

            if (preorder[i]< root) return false;
            stack.push(preorder[i]);
        }

        return true;
    }
}
