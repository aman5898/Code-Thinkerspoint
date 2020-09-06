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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        inorder(root1,list1);
        inorder(root2,list2);
        
        List<Integer> res = new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                res.add(list1.get(i));
                i++;
            }else{
                res.add(list2.get(j));
                j++;
            }
        }
        
        while(i<list1.size()){
            res.add(list1.get(i));
            i++;
        }
        
        while(j<list2.size()){
            res.add(list2.get(j));
            j++;
        }
        
        return res;
    }
    
    public void inorder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
}