class Solution {
    int[] ans; 
    int count;
    
    public int kthSmallest(TreeNode root, int k) {
        ans = new int[1];
        count = k;
        inorderTraversal(root);
        return ans[0];
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        
        count--;
        if (count == 0) {
            ans[0] = root.val;
            return;
        }
        
        inorderTraversal(root.right);
    }
}

