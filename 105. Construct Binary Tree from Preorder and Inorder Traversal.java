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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> indexmap = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                indexmap.put(inorder[i], i);
            }
            return helper(0, 0, inorder.length - 1, preorder, inorder, indexmap);
        }
        public TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder, HashMap<Integer,Integer> indexmap) {
            if(prestart == preorder.length || inend < instart) return null;
            TreeNode root = new TreeNode(preorder[prestart]);
            int inIndex = indexmap.get(preorder[prestart]);
            root.left = helper(prestart + 1, instart, inIndex - 1, preorder, inorder, indexmap);
            root.right = helper(prestart + inIndex - instart + 1, inIndex + 1, inend, preorder, inorder, indexmap);
            return root;
        }
}