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
    public boolean isValidBST(TreeNode root) {
        return inorderTraverse(root,null, null);
    }

    private boolean inorderTraverse(TreeNode root, Integer lVal, Integer rVal){
        if(root == null)
            return true;

        if((root.left != null)&&(!inorderTraverse(root.left, lVal, root.val)))
               return false;

        if((rVal != null)&&(root.val >= rVal))
            return false;
        if((lVal != null)&&(root.val <= lVal))
            return false;

        if((root.right != null)&&(!inorderTraverse(root.right, root.val, rVal)))
               return false;

        return true;
    }
}
