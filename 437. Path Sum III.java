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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }
    public int helper(TreeNode node,int currsum , int target, HashMap<Integer, Integer> map){
        if(node == null) return 0;
        currsum += node.val;
        int res = map.getOrDefault(currsum - target, 0);
        int prev = map.getOrDefault(currsum, 0);
        map.put(currsum, prev + 1);
        res += helper(node.left, currsum, target, map) + helper(node.right, currsum, target, map);
        map.put(currsum, map.get(currsum) - 1);
        return res;
    }
}