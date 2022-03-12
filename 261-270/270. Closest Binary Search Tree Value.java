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
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root==null) return 0;

        TreeNode upper = root;
        TreeNode lower = root;

        while (root != null){
            if (root.val> target){
                upper = root;
                root = root.left;
            }
            else if (root.val< target){
                lower = root;
                root= root.right;
            }
            else{
                return root.val;
            } 
        }
        return Math.abs(upper.val-target)> Math.abs(target-lower.val)? lower.val:upper.val;
    }
}
