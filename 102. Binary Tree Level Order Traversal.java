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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> sublist = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = que.poll();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                sublist.add(node.val);
            }
            list.add(sublist);
        }
        return list;
    }
}