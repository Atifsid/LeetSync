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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        if(root == null) return postorder;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(st1.isEmpty() != true){
            root = st1.pop();
            st2.push(root);
            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
        }
        while(st2.isEmpty() != true){
            postorder.add(st2.pop().val);
        }
        return postorder;
    }
}

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         return postOrder(res, root);
//     }
    
//     public List<Integer> postOrder(List<Integer> res, TreeNode node){
//         if(node == null) return res;
        
//         postOrder(res, node.left);
//         postOrder(res, node.right);
//         res.add(node.val);
        
//         return res;
//     }
// }