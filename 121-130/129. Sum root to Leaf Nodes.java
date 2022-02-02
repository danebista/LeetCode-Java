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
    int result=0;
    public int sumNumbers(TreeNode root) {
       helper(root, 0);
       return result;
    }
    
    public void helper(TreeNode root, int value){
        int current = value *10+ root.val;
        if (root.left == null && root.right==null){
            result+=current;
            return;
        }
        
        if (root.left!=null) helper(root.left, current);
        if (root.right!=null) helper(root.right, current);
    }
}
