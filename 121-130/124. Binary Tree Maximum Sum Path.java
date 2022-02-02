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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] helper = new int[1];
        helper[0] = Integer.MIN_VALUE;
        helperFunc(root, helper);
        return helper[0];
    }
    
    public int helperFunc(TreeNode root, int[] helper){
        if (root==null) return 0;
        
        int left = Math.max(0, helperFunc(root.left, helper));
        int right = Math.max(0,helperFunc(root.right, helper));
        
        helper[0] = Math.max(helper[0], right+left+root.val);
        
        return root.val + Math.max(left, right);
    }
}
