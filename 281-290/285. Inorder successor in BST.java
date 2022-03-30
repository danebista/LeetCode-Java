/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while(root!=null){
            if (root.val == p.val) {
                break;
            }
            else if (root.val < p.val){
                root = root.right;
            }
            else {
                successor = root;
                root = root.left;
            }
        }

        if (root==null) return null;
        if (p.right==null) return successor;
        p=p.right;
        while (p.left!=null){
            p=p.left;
        }

        return p;
    }
}
