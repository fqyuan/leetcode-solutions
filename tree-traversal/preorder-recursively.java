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
    public void preorderhelper(List<Integer> list, TreeNode node){
        if(node == null) return;
        list.add(node.val);
        preorderhelper(list, node.left);
        preorderhelper(list, node.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderhelper(list, root);
        return list;
    }
}