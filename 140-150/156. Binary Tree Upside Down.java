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
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        return helper(root);
    }

    public TreeNode helper(TreeNode curr){
        if (curr.left == null){
            return curr;
        }

        TreeNode newRoot = helper(curr.left);
        curr.left.left = curr.right;
        curr.left.right = curr;
        curr.left = null;
        curr.right = null;

        return newRoot;
    }
}
