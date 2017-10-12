/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){  // cur != null(u can push it) meaning the stack is not empty
            while (cur != null) {
            	s.push(cur);
                cur = cur.left;         // push left subtree into stack
            } 
            // reach the leftmost node || right subtree have been traversed
            cur = s.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
        
    }
}