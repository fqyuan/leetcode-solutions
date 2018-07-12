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
	// Two Stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> first = new Stack<>();  // store parents
        Stack<TreeNode> second = new Stack<>();  // store children
        first.push(root);
        while(!first.isEmpty()){
        	TreeNode cur = first.pop();
        	second.push(cur);
		// 右儿子优先的preorder，
        	if(cur.left != null) first.push(cur.left);
        	if(cur.right != null) first.push(cur.right);   
        }

        while(!second.isEmpty()) {
        	list.add(second.pop().val);
        }
        return list;
    }
    /* One Stacks v1
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> s = new Stack<>(); 
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
        	while(cur != null){
	         	if(cur.right != null) s.push(cur.right);
	        	s.push(cur);
	        	cur = cur.left;       		
        	}
        	cur = s.pop();
        	if(!s.isEmpty() && cur.right == s.peek()) {  // check whether cur is the last one 
        		TreeNode tmp = cur;
        		cur = s.pop();
        		s.push(tmp);
        	} else {
        		list.add(cur.val);
        		cur = null;
        	}

        }
        return list;
    }
    */
    /* One Stacks v2
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> s = new Stack<>();         s.push(root);

        TreeNode pre = null;
        while(!s.isEmpty()){
			TreeNode cur = s.peek();
			if(pre == null || pre.left == cur || pre.right == cur){  // go down;
				if (cur.left != null) // left first
					s.push(cur.left);
				else if(cur.right != null)
					s.push(cur.right);
				else {
					s.pop();
					list.add(cur.val);
				}
			} else if(pre == cur.left){   // go up
				if(cur.right != null) {
					s.push(cur.right);
				}
				else {
					s.pop();
					list.add(cur.val);
				}

			} else if(pre == cur.right) {  // go up
				s.pop();
				list.add(cur.val);
			}
			pre = cur;
        }
        return list;
    }
    */
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
		System.out.println(s.postorderTraversal(root));
    }
    */
}
