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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root==null) return result;
        queue.add(root);
        
        while (!queue.isEmpty()){
            List<Integer> current = new ArrayList();
            int size = queue.size();
            for (int i=0; i< size; i++){
                TreeNode curr = queue.remove();
                current.add(curr.val);
                if (curr.left != null){
                    queue.add(curr.left);
                }
                
                if (curr.right !=null){
                    queue.add(curr.right);
                }
            }
            result.add(current);
        }
        
        Collections.reverse(result);
        
        return result;
    }
}
