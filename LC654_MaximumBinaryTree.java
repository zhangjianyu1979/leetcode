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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if((nums == null)||(nums.length ==0))
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);

        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right){
        int idx = left;
        if(left > right)
            return null;
        if(left == right)
            return new TreeNode(nums[left]);
        int maxVal = nums[left];  //放在前面会报错，先检查异常，left可能越界
        for(int i = left + 1; i <= right; i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                idx = i;
            }
        }
        TreeNode res = new TreeNode(nums[idx]);
        res.left = constructMaximumBinaryTree(nums, left, idx - 1);
        res.right = constructMaximumBinaryTree(nums, idx + 1, right);
        return res;
    }
}
