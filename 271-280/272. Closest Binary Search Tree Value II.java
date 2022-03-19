/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    Stack<Integer> stack;
    Queue<Integer> queue;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        stack = new Stack();
        queue = new LinkedList();
        
        helper(root, target);
        List<Integer> result = new ArrayList();

        while (k!=0){
            if (stack.isEmpty()){
                result.add(queue.poll());
            }
            else if (queue.isEmpty()){
                result.add(stack.pop());
            }
            else{
                double diff1 = Math.abs(stack.peek()- target);
                double diff2 = Math.abs(target - queue.peek());

                if (diff1< diff2){
                    result.add(stack.pop());
                }
                else {
                    result.add(queue.poll());
                }
            }

            k--;
        }

        return result;
    }

    public void helper(TreeNode root, double target){
        if (root==null) return;
        helper(root.left, target);
        if ((double)root.val< target){
            stack.push(root.val);
        }
        else{
            queue.offer(root.val);
        }
        helper(root.right, target);
    }
}
  