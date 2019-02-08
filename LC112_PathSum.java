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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root ==null)
            return false;
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int parentSum){
        if((root.left == null)&&(root.right == null))
            return root.val + parentSum == sum;
        if((root.left != null)&&hasPathSum(root.left, sum, parentSum+root.val))
            return true;
        if((root.right != null)&&hasPathSum(root.right, sum, parentSum+root.val))
            return true;
        return false;
    }
}
// 初始化和递归中，增加当前节点还是递归节点的值要统一
