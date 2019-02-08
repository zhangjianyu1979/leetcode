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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode root, int level){
        int resLeft = Integer.MAX_VALUE;
        int resRight = Integer.MAX_VALUE;
        if((root.left == null)&&(root.right == null))
            return level;
        if(root.left != null)
            resLeft = minDepth(root.left,level+1);
        if(root.right != null)
            resRight = minDepth(root.right,level+1);
        return Math.min(resLeft,resRight);
    }
}
// 叶节点的定义理解不对
