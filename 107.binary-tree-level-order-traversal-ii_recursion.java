public class Solution {
	   public List<List<Integer>> levelOrderBottom(TreeNode root) {
		   List<List<Integer>> list = new LinkedList<List<Integer>>();
		   maker(root, 0, list);
		   return list;
	    }

	    private void maker(TreeNode root, int level, List<List<Integer>> list) {
	    	if (root == null) return;
	    	if (level >= list.size()) {
	    		list.add(0, new LinkedList<Integer>());
	    	}
	    	maker(root.left, level + 1, list);
	    	maker(root.right, level + 1, list);
	    	list.get(list.size() - level - 1).add(root.val);
	    } 
}