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
    // same as levelorder, but the direction of putting sublist varies
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        boolean lefttoright = true;
        while(!s.isEmpty()){
            int n = s.size();
            List<Integer> sublist = new ArrayList<>(n);
            while(n-- > 0){
                TreeNode node = s.poll();
                if(node.left != null) s.add(node.left);
                if(node.right != null) s.add(node.right);

                if(lefttoright) {
                    sublist.add(node.val);   // left to right order
                } else {
                    sublist.add(0, node.val); // right to left

                }
            }
            list.add(sublist);
            lefttoright = !lefttoright;
        }
        return list;
    }
    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        helper(root, list, 0);
        return list;
    }
    
    public void helper(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null) return;
        
        if(level >= list.size()) list.add(new ArrayList<Integer>());
        List<Integer> sublist = list.get(level);
        if(level % 2 == 0)
            sublist.add(root.val);
        else 
            sublist.add(0,root.val);
        helper(root.left, list, level+1);
        helper(root.right, list, level + 1);
    }
    */
}