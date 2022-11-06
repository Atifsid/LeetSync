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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return preorder(res, root);
        //return res;   
    }
    
    public List<Integer> preorder(List<Integer> res, TreeNode node){
        
        if(node == null){
            return res;
        }
        res.add(node.val);
        preorder(res,node.left);
        preorder(res,node.right);
        return res;
    }
}