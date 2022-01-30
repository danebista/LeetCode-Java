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
    HashMap<Integer, Integer> hm = new HashMap();
    int prefix = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i=0; i< inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start , int end){
        if (start>end) return null;
        
        TreeNode root = new TreeNode(preorder[prefix++]);
        if (start==end) return root;
        int inorderIndex = hm.get(root.val);
        root.left = helper(preorder, inorder, start, inorderIndex-1);
        root.right = helper(preorder, inorder, inorderIndex+1, end);
        
        return root;
    }
}
