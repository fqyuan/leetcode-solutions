/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 *
 * algorithms
 * Easy (40.37%)
 * Total Accepted:    137K
 * Total Submissions: 339.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	Queue<TreeNode> tem = new LinkedList<TreeNode>();
    	if (root == null) return res;
    	tem.offer(root);
    	while (!tem.isEmpty()) {
    		LinkedList<Integer> level = new LinkedList<Integer>();
    		int levelsize = tem.size();
    		for (int i = 0; i < levelsize; i++) {
    			if (tem.peek().left != null) tem.offer(tem.peek().left);
    			if (tem.peek().right != null) tem.offer(tem.peek().right);
    			level.add(tem.poll().val);
    			
    		}
    		res.add(0, level);
    		
    	}
    	return res;
    }
}
