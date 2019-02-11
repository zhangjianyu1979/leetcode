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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null)
            return list;
        list = inorderTraversal(root.left, list);
        list.add(root.val);
        list = inorderTraversal(root.right, list);
        return list;
    }
}
