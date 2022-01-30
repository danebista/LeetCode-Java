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
    int postfix;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postfix = postorder.length-1;
        
        for (int i=0; i< inorder.length; i++){
            hm.put(inorder[i],i);
        }
        
       return helper(inorder, postorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if (start> end) return null;
        
        TreeNode root = new TreeNode(postorder[postfix--]);
        if (start == end) return root;
        int inorderIndex = hm.get(root.val);
        root.right = helper(inorder, postorder, inorderIndex+1, end);
        root.left = helper(inorder, postorder, start, inorderIndex-1);
        
        return root;
    }
}
