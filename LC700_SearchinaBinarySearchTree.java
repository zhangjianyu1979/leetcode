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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode res = root;
        while(res != null){
            if(res.val == val)
                return res;
            if(res.val > val){
                res = res.left;
                continue;
            }
            if(res.val < val){
                res = res.right;
                continue;
            }
        }
        return res;
    }
}
// 注意不要忘记continue
// 代码要走一遍，左右反掉了 20190208
