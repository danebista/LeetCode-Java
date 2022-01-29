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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        helper(root, targetSum, new ArrayList(), result);
        return result;
    }
    public void helper(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result){
        if(root==null) return;
        
        current.add(root.val);
        if (targetSum-root.val==0 && root.left==null && root.right==null){
        
            result.add(current);
            return;
        }
        
        helper(root.left, targetSum-root.val, new ArrayList(current), result);
        helper(root.right, targetSum-root.val, new ArrayList(current), result);
        
    }
}
