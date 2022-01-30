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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        if (root== null) return result;
        
        queue.add(root);
        int n=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentList = new ArrayList();
          
            for (int i=0; i<size;  i++){
                TreeNode curr = queue.remove();
                currentList.add(curr.val);
                    if (curr.left != null){
                        queue.add(curr.left);
                    }
                    if (curr.right != null){
                        queue.add(curr.right);
                    }   
            }
            if (n%2==0){
                Collections.reverse(currentList);
            }
            result.add(currentList);
            n+=1;
        }
        return result;
    }
}
