# Lowest Common Ancestor(LCT)

标签（空格分隔）： Leetcode

---

#### [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)
> BST,利用节点大小的顺序

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val - p.val) * (root.val - q.val) > 0) { //root 的值位于两者的两边，乘积为负
            root =  root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}
```

#### [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)
> 二叉树的最低公共祖先，分治法找p,q,
如果root就是p或q,直接返回root；
如果左右子树中共同存在p,q，返回root；
如果只有其中一个，返回一个；
都没有，返回null

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null) {
            if(right != null) {
                return root;
            } else {
                return left;
            }
        } else {
            return right;
        }
        //    return left == null ? right : right == null ? left : root;

    }
}
```



