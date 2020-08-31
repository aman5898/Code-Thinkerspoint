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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null){
            return null;
        }
        
        if(root.val == key){
            if(root.left==null&&root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                int rightMin = findMin(root.right);
                root.val = rightMin;
                root.right = deleteNode(root.right,rightMin);
                return root;
            }
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{
            root.left = deleteNode(root.left,key);
        }
        
        
        return root;
    }
    
    public int findMin(TreeNode node){
        
        if(node.left==null){
            return node.val;
        }
        
        return findMin(node.left);
    }
    
    
}