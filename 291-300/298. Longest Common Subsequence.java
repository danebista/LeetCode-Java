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
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        int[] max = new int[1];
        longestConsecutiveNumbers(root, 0, 0, max);
        return max[0];
    }

    public void longestConsecutiveNumbers(TreeNode root, int count, int target, int[]max){
        if (root == null){
            return;
        }
        else if(root.val == target){
            count+=1;
        }
        else{
            count=1;
        }
        max[0] = Math.max(max[0], count);
        longestConsecutiveNumbers(root.left, count, root.val+1, max);
        longestConsecutiveNumbers(root.right, count, root.val+1, max);
    }
}
