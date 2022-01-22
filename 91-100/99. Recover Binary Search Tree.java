/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode first = null;
        TreeNode last = null;
        TreeNode prev = new TreeNode(-Integer.MIN_VALUE);
        int count = 0;
        while (!stack.isEmpty() || root!=null){
            while(root!=null){
                
                stack.push(root);
                root =root.left;
              
            }
            
            root=stack.pop();
            if (root.val< prev.val){
                if (first==null){
                    first = prev;
                    last = root;   
                }else{
                    last = root;
                }
            }
            
            prev= root;
            root = root.right;
        }
       
         int temp = first.val;
         first.val = last.val;
         last.val = temp;
        
    }
}
