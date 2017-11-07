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
    public void postorderhelper(List<Integer> list, TreeNode node){
        if(node == null) return;
        postorderhelper(list, node.left);
        postorderhelper(list, node.right);
        list.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderhelper(list, root);
        return list;
    }
}