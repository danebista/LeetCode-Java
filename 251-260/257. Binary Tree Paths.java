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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        helper(result, "", root);
        return result;
    }
    public void helper(List<String> result, String sb, TreeNode root){
        if (sb.length()==0) sb+=(String.valueOf(root.val));
        else sb+="->"+String.valueOf(root.val);
        
        if (root.left ==null && root.right==null){
            result.add(sb);
        }
        
        if (root.left != null) helper(result, sb, root.left);
        if (root.right!=null) helper(result, sb, root.right);
    }
}
