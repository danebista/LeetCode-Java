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
    public int countNodes(TreeNode root) {
        if (root ==null)return 0;
        int left_count= 1;
        TreeNode left = root.left;
        while (left!=null){
            left_count +=1;
            left = left.left;
        }
        int right_count=1;
        TreeNode right = root.right;
        while (right!=null){
            right_count +=1;
            right = right.right;
        }
        
        if (left_count == right_count) return (int)Math.pow(2, left_count)-1;
        
        return 1+countNodes(root.left)+ countNodes(root.right);
    }
}
