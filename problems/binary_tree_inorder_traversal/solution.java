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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         return inorder(res, root);
//     }
    
//     public List<Integer> inorder(List<Integer> res, TreeNode node){
        
//         if(node == null){
//             return res;
//         }
//         inorder(res,node.left);
//         res.add(node.val);
//         inorder(res,node.right);
//         return res;
//     }
// }


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                
                node = st.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}