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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int[]res = calculateMaxDepth(root);
        
        return res[0]==0;
        
    }
    
    public int[] calculateMaxDepth(TreeNode root){
        if (root == null) {
            int ans[] = new int[2];
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        } ;
        
        int[] left = calculateMaxDepth(root.left);
        int[] right = calculateMaxDepth(root.right);
        int balance = (left[0]==0 && right[0]==0 && Math.abs(left[1]-right[1])<=1)?0:1;
        int[] ans= new int[2];
        ans[0]=balance;
        ans[1] = Math.max(left[1], right[1]) +1;
        return ans;
    }
}
