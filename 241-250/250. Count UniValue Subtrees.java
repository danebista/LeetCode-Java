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
    int count;
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        count=0;
        // write your code here
        helper(root);
        return count;
    }

    public boolean helper(TreeNode root){
        if (root==null) return true;
        boolean x = helper(root.left);
        boolean y =  helper(root.right);
        
        if (x && y && (root.left==null || root.left.val==root.val)
         && (root.right==null || root.right.val==root.val)) {
             count++;
             return true;
         }
        
        return false;
    }
}
