import java.util.Arrays;
//
//
// 2019/2/17 下午2:00
class BST{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        BST bst = new BST(nums);
        System.out.println(bst.LCA(bst.root,2,6).val);
        System.out.println("begin print distances");
        System.out.println(bst.findDistance(2,5));
        System.out.println(bst.findDistance(1,6));
        System.out.println(bst.findDistance(1,2));
        System.out.println(bst.findDistance(1,1));
    }
    public class BSTNode{
        private int val;
        public BSTNode left, right;
        public BSTNode(int val){
            this.val = val;
            left = right = null;
        }
    }
    private BSTNode root;

    public BST(int[] nums){
        Arrays.sort(nums); // 根据题目决定是否要sort
        root = buildBST(nums, 0, nums.length-1);
        printTree(root);
    }

    public BSTNode buildBST(int[] nums, int l, int r){
        if(l > r)
            return null;
        int mid = l + (r - l)/2;
        BSTNode node  = new BSTNode(nums[mid]);
        node.left = buildBST(nums, l , mid - 1);
        node.right = buildBST(nums, mid + 1, r);
        return node;
    }
    private void printTree(BSTNode node){
        if(node == null)
            return;
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
    private BSTNode LCA(BSTNode root, int n1, int n2){
        // 后续遍历,查找不是根据节点，而是根据值
        if(root == null)
            return null;
        // 不需要判断left是否为空
        //System.out.println(root.val);
        if((root.val > n1 )&&( root.val > n2))
            return LCA(root.left, n1, n2);
        if((root.val < n1 )&&( root.val < n2))
            return LCA(root.right, n1, n2);
        return root;
    }

    private int distOfNodes(BSTNode node, int n, int dist){
//        System.out.println(dist);
        if(node.val > n)
            return distOfNodes(node.left, n, dist+1);
        if(node.val < n)
            return distOfNodes(node.right, n, dist+1);
        return dist;
    }

    private int findDistance(int n1, int n2){
        BSTNode node = LCA(root, n1, n2);
        if(node == null)
            return -1;

        return distOfNodes(node, n1, 0) + distOfNodes(node, n2, 0);
    }
}
