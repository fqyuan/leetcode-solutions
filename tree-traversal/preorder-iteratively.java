/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){ 
        	TreeNode cur = s.pop();
            list.add(cur.val);            				// pop to print 
           	if(cur.right != null) s.push(cur.right);	// push right
           	if(cur.left != null) s.push(cur.left);		// push left
        }
        return list;
    }
    /*
    public static void main(Stirng[] args){
    	Solution s = new Solution();
    	TreeNode root = new TreeNode(0);
		root.left =  new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left =  new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left =  new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(s.preorderTraversal(root));
    }
    */
}