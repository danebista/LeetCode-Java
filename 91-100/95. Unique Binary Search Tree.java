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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int left, int right){
        List<TreeNode> root = new ArrayList();
        if (left > right) {
            root.add(null);
            return root;
            }
        if (left == right) {
            root.add(new TreeNode(left));
            return root;                                          
                                                        
            }                                                     
        
        for (int i=left; i<=right; i++){
            List<TreeNode> leftTree = helper(left, i-1);
            List<TreeNode> rightTree = helper(i+1, right);
            
            for(TreeNode Ltree: leftTree){
                for (TreeNode Rtree: rightTree){
                    TreeNode temp = new TreeNode(i);
                    temp.left = Ltree;
                    temp.right = Rtree;
                    root.add(temp);
                }
            }
        }
        return root;
    }
}
