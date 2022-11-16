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

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         return preorder(res, root);   
//     }
    
//     public List<Integer> preorder(List<Integer> res, TreeNode node){
        
//         if(node == null){
//             return res;
//         }
//         res.add(node.val);
//         preorder(res,node.left);
//         preorder(res,node.right);
//         return res;
//     }
// }


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(st.isEmpty() != true){
            root = st.pop();
            preorder.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorder;
    }
}