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
    
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,null);
        return sum;
    }
    
    private void helper(TreeNode node,TreeNode parent){
        
        if(node==null){
            return;
        }
        
        if(node.left==null&&node.right==null){
            if(parent!=null && parent.left==node){
              sum+=node.val;
            }
        }
        
        helper(node.left,node);
        helper(node.right,node);
    }
}