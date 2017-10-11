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
    public void inorderhelper(List<Integer> list, TreeNode node){
        if(node == null) return;
        inorderhelper(list, node.left);
        list.add(node.val);
        inorderhelper(list, node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderhelper(list, root);
        return list;
    }
}